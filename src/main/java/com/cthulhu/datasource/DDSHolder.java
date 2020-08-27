package com.cthulhu.datasource;

import org.apache.tomcat.jdbc.pool.DataSource;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Timer;

/**
 * 动态数据源管理器
 */
class DDSHolder {
	/**
	 * 管理动态数据源列表。<工程编码，数据源>
	 */
	private Map<String, DDSTimer> ddsMap = new HashMap<>();
	/**
	 * 通过定时任务周期性清除不使用的数据源
	 */
	private static Timer clearIdleTask = new Timer();
	static {
		clearIdleTask.schedule(new ClearIdleTimerTask(),5000,60*1000);
	}

	private DDSHolder() {
	}

	static DDSHolder instance() {
		return DDSHolderBuilder.instance;
	}

	private static class DDSHolderBuilder{
		private static DDSHolder instance = new DDSHolder();
	}
	synchronized void addDDS(String projectCode, DataSource dds){
		DDSTimer ddst = new DDSTimer(dds);
		ddsMap.put(projectCode, ddst);
	}

	synchronized DataSource getDDS(String projectCode){
		if (ddsMap.containsKey(projectCode)){
			DDSTimer ddst = ddsMap.get(projectCode);
			ddst.refreshTime();
			return ddst.getDds();
		}
		return null;
	}

	synchronized void clearIdleDDS(){
		ddsMap.entrySet().removeIf(entry -> entry.getValue().checkAndClose());
	}
}
