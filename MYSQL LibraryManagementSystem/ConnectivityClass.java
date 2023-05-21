package com.jdbcproject.LibraryManagementSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class ConnectivityClass {
Connection CreateCon() throws SQLException {
		try
		{
    		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagement", "root", "Sana@123");
    		return con;
		}catch(Exception e) {
	e.printStackTrace();
	}
		return null;	
}
}

