package com.cthulhu.datasource;

import java.util.HashMap;
import java.util.Map;

class ProjectDBMgr {

	private Map<String, String> dbNameMap = new HashMap<>();

	private Map<String, String> dbIPMap = new HashMap<>();

	private ProjectDBMgr() {
		dbNameMap.put("test", "dy_test_db");
		dbNameMap.put("product", "dy_prod_db");
		dbNameMap.put("develop", "dy_dev_dp");

		dbIPMap.put("test", "127.0.0.1");
		dbIPMap.put("product", "127.0.0.1");
		dbIPMap.put("develop", "127.0.0.1");
	}

	static ProjectDBMgr instance(){
		return ProjectDBMgrBuilder.instance;
	}

	String getDBName(String projectCode){
		if (dbNameMap.containsKey(projectCode))	{
			return dbNameMap.get(projectCode);
		}
		return "";
	}

	String getDBIP(String projectCode){
		if (dbIPMap.containsKey(projectCode)){
			return dbIPMap.get(projectCode);

		}
		return "";
	}

	private static class ProjectDBMgrBuilder {
		private static ProjectDBMgr instance = new ProjectDBMgr();
	}
}
