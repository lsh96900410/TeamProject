package common;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DataSource {
	private String driverClass;
	private String url;
	private String user;
	private String password;

	public DataSource() throws Exception {
		// TODO Auto-generated constructor stub
		Properties pro = new Properties();
		InputStream fis = DataSource.class.getResourceAsStream("/jdbc.properties");
		pro.load(fis);
		driverClass = pro.getProperty("driverClass");
		url = pro.getProperty("url");
		user = pro.getProperty("user");
		password = pro.getProperty("password");
	}

	public Connection getConnection() throws Exception {
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url, user, password);
		return con;
	}

	public void close(Connection con) throws Exception {
		con.close();
	}

}
