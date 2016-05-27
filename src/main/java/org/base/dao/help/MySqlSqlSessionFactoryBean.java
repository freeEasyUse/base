package org.base.dao.help;

import java.sql.SQLException;

import javax.sql.DataSource;
import javax.sql.XADataSource;

import org.mybatis.spring.SqlSessionFactoryBean;

import com.atomikos.jdbc.SimpleDataSourceBean;

@SuppressWarnings("all")
public class MySqlSqlSessionFactoryBean extends SqlSessionFactoryBean {

	private SimpleDataSourceBean simpleDataSourceBean;
	
	
	
	public SimpleDataSourceBean getSimpleDataSourceBean() {
		return simpleDataSourceBean;
	}



	public void setSimpleDataSourceBean(SimpleDataSourceBean simpleDataSourceBean) {
		this.simpleDataSourceBean = simpleDataSourceBean;
	}



	public void setDataSource(DataSource dataSource) {
		try {
			dataSource.setLoginTimeout(simpleDataSourceBean.getLoginTimeout());
			dataSource.setLogWriter(simpleDataSourceBean.getLogWriter());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.setDataSource(dataSource);
	}

}
