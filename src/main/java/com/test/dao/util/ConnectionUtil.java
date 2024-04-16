package com.test.dao.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Logger;



public class ConnectionUtil {

	 private static final Logger log;
	 private static Properties properties;
	 static {
	        System.setProperty("java.util.logging.SimpleFormatter.format", "[%4$-7s] %5$s %n");
	        log =Logger.getLogger(ConnectionUtil.class.getName());
	        Properties properties = new Properties();
	    }
	public static Connection getConnection() throws Exception{
		log.info("Loading application properties");
       
        //properties.load(ConnectionUtil.class.getClassLoader().getResourceAsStream("application.properties"));
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String url = "jdbc:sqlserver://dockersqldbserver.database.windows.net:1433;database=dockervmsqldb;user=dockervmsqlusr@dockersqldbserver;password=dockersqlusr@123;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
        Connection connection = DriverManager.getConnection(url, properties);
        log.info("Database connection test: " + connection.getCatalog());
        return connection;
	}
	
	public static void closeConnection(Connection connection) throws SQLException {
		connection.close();
	}
	
	
	
}
