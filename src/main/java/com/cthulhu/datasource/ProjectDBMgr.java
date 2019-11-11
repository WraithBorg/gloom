package com.cthulhu.datasource;

import java.util.HashMap;
import java.util.Map;

public class ProjectDBMgr {

	private Map<String, String> dbNameMap = new HashMap<>();

	private Map<String, String> dbIPMap = new HashMap<>();

	private ProjectDBMgr() {
		dbNameMap.put("project_001", "userin");
		dbNameMap.put("project_002", "userout");
		dbNameMap.put("project_003", "db_project_003");

		dbIPMap.put("project_001", "127.0.0.1");
		dbIPMap.put("project_002", "127.0.0.1");
		dbIPMap.put("project_003", "127.0.0.1");
	}

	public static ProjectDBMgr instance(){
		return ProjectDBMgrBuilder.instance;
	}

	public String getDBName(String projectCode){
		if (dbNameMap.containsKey(projectCode))	{
			return dbNameMap.get(projectCode);
		}
		return "";
	}

	public String getDBIP(String projectCode){
		if (dbIPMap.containsKey(projectCode)){
			return dbIPMap.get(projectCode);

		}
		return "";
	}

	private static class ProjectDBMgrBuilder {
		private static ProjectDBMgr instance = new ProjectDBMgr();
	}
}
