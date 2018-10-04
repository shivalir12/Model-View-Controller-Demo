package com.nc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionUtil {

	
	private static Connection connection;
	private static final String URL="jdbc:mysql://localhost:3306/sit";
	private static final String USER="root";
	private static final String PASS="shivali";
	
	private ConnectionUtil() {}
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			if (connection==null ||  connection.isClosed()) {
			
				connection=DriverManager.getConnection(URL,USER,PASS);
			}
		}catch(SQLException e) {
			System.out.println("Problem in getting connection."+ e.getMessage());
		}catch(ClassNotFoundException e ) {
			e.printStackTrace();
		}
		return connection;
	}
}
