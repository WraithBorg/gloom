package com.cthulhu.datasource;

import org.apache.tomcat.jdbc.pool.DataSource;

/**
 * 动态数据源定时器管理。长时间无访问的数据库连接关闭。
 */
class DDSTimer {

	/**
	 * 空闲时间周期。超过这个时长没有访问的数据库连接将被释放。默认为10分钟
	 */
	private static final long idlePeriodTime = 10 * 60 * 1000;
	/**
	 * 动态数据源
	 */
	private DataSource dds;
	/**
	 * 上一次访问的时间
	 */
	private long lastUseTime;

	DDSTimer(DataSource dds) {
		this.dds = dds;
		this.lastUseTime = System.currentTimeMillis();
	}

	/**
	 * 更新最近访问时间
	 */
	void refreshTime() {
		lastUseTime = System.currentTimeMillis();
	}

	/**
	 * 检测数据连接是否超时关闭。
	 *
	 */
	boolean checkAndClose() {
		if (System.currentTimeMillis() - lastUseTime > idlePeriodTime) {
			dds.close();
			return true;
		}
		return false;
	}

	DataSource getDds() {
		return dds;
	}
}
