package mx.manuelr.web.dao;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionUtil {
	private static ComboPooledDataSource comboPooledDataSource;

	static {
		try {
			comboPooledDataSource = new ComboPooledDataSource();
			comboPooledDataSource.setDriverClass("org.postgresql.Driver");
			comboPooledDataSource.setJdbcUrl("jdbc:postgresql://localhost:5432/programacion-web");
			comboPooledDataSource.setUser("postgres");
			/** pass server **/
			comboPooledDataSource.setPassword("give1618"); 
//			comboPooledDataSource.setPassword("tomcat");
			comboPooledDataSource.setAcquireIncrement(5);
			comboPooledDataSource.setInitialPoolSize(5);
			comboPooledDataSource.setMaxPoolSize(20);
			comboPooledDataSource.setMaxIdleTime(0);
			comboPooledDataSource.setMinPoolSize(5);
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws SQLException {
		return comboPooledDataSource.getConnection();
	}
}
