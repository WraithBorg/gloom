package com.cthulhu.datasource;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.SQLException;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 定义动态数据源派生类。从基础的DataSource派生，动态性自己实现。
 *
 * @author Administrator
 */
public class DynamicDataSource extends DataSource {

	private static final Logger logger = LoggerFactory.getLogger(DynamicDataSource.class);

	@Override
	public Connection getConnection() throws SQLException {
		String projectCode = DBIdentifier.getProjectCode();
		DataSource dds = DDSHolder.instance().getDDS(projectCode);
		if (dds == null) {
			try {
				DataSource newDDS = initDDS(projectCode);
				DDSHolder.instance().addDDS(projectCode, newDDS);
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		dds = DDSHolder.instance().getDDS(projectCode);
		try {
			return dds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	private DataSource initDDS(String projectCode) throws IllegalAccessException {
		DataSource dds = new DataSource();
		PoolProperties property = new PoolProperties();
		Field[] pfields = PoolProperties.class.getDeclaredFields();
		for (Field f : pfields) {
			f.setAccessible(true);
			Object value = f.get(this.getPoolProperties());
			try {
				f.set(property, value);
			}catch (Exception e){
				//有一些static final的属性不能修改。忽略。
				continue;
			}
		}
		dds.setPoolProperties(property);
		String urlFormat = this.getUrl();
		String url = String.format(urlFormat, ProjectDBMgr.instance().getDBIP(projectCode), ProjectDBMgr.instance().getDBName(projectCode));
		dds.setUrl(url);
		return dds;
	}
}
