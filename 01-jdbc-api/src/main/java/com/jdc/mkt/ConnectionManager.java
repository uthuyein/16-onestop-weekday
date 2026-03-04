package com.jdc.mkt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {

	private static final String URL = "jdbc:mysql://localhost:3306/testDb";
	private static final String USER = "root";
	private static final String PASSWORD = "admin";
	
	public static Connection  getConnectionWithString() throws SQLException {
//		jdbc:mysql://localhost:3306/testDb?user=root&password=admin
		return DriverManager.getConnection(URL+"?user="+ USER+"&password="+ PASSWORD);
	}
	
	public static Connection getConnectionWithStrings() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}
	
	public static Connection getConnectionWithProperties() throws SQLException {
		Properties p = new Properties();
		p.put("user", USER);
		p.put("password", PASSWORD);
		
		return DriverManager.getConnection(URL, p);
	}
}








