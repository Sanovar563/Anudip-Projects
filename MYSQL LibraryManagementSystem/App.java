package com.jdbcproject.LibraryManagementSystem;

import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class App 
{
    public static void main( String[] args ) throws SQLException
    {
      //call the connection class and method in main method
    	ConnectivityClass obj=new ConnectivityClass();
    	 Connection con= obj.CreateCon();
    	
		if(con.isClosed())
		{
			System.out.println("connection not established");
		}
		else
		{
			System.out.println("Connection Established succesfully");

	        // create an object of the table class and call createtable() method to create a table
	        table t = new table();
	        t.con = con;
	        t.createtable();
	        t.insertdata();    
		}
	} 
}

class table
{

	Connection con;
	public void createtable()
	{
		//query to create the table in the database
				String q= "create table lib1(Bookid int primary key, BookName varchar(50) not null, AuthorName varchar(50) not null)";
				
				Statement s = null;
				try {
					s = con.createStatement();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				try {
					s.executeUpdate(q);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				System.out.println("The table created successfully");	
	}
	public void insertdata() throws SQLException
	{
		
		  Scanner sc = new Scanner(System.in);
	         {
	            // display the options to the user
	            System.out.println("Type option:");
	            System.out.println("1. Add new data");
	            System.out.println("2. Update data");
	            System.out.println("3. View data");
	            System.out.println("4. Delete data");
	            System.out.println("5. Exit");

	            // read the user's choice
	            int choice = sc.nextInt();
				// execute the corresponding method based on the user's choice
	            switch (choice) {
	                case 1:
	                    System.out.println("Enter bookid, book name, and author name:");
	                    int bookId = sc.nextInt();
	                    String bookName = sc.next();
	                    String authorName = sc.next();
	                    System.out.println("Data added successfully");
	                    break;
	                case 2:
	                    System.out.println("Enter bookid, new book name, and new author name:");
	                    bookId = sc.nextInt();
	                    bookName = sc.next();
	                    authorName = sc.next();
	                  
	                    System.out.println("Data updated successfully");
	                    break;
	              
	                case 3:
	                    System.out.println("Enter bookid to delete:");
	                    bookId = sc.nextInt();
	                   
	                    System.out.println("Data deleted successfully");
	                    break;
	             
	                default:
	                    System.out.println("Invalid choice");
	            }
	        }
		 String q = "INSERT INTO lib1(Bookid, BookName, AuthorName) VALUES (?, ?, ?)";
	        PreparedStatement ps = con.prepareStatement(q);
//	         set the values for the query parameters
	        ps.setInt(1, 6);
	        ps.setString(2, "Hamlet");
	        ps.setString(3, "Shakespeare");
//	        // execute the query
	      ps.executeUpdate();
       System.out.println("Data update successfully");
       
       String q1 = "INSERT INTO lib1(Bookid, BookName, AuthorName) VALUES (?, ?, ?)";
       PreparedStatement ps1 = con.prepareStatement(q);
       // set the values for the query parameters
       ps.setInt(1, 3);
       ps.setString(2, "Othello");
       ps.setString(3, "Shakespeare");
       // execute the query
       ps.executeUpdate();
     	System.out.println("Data update successfully");
  
	  String q3 = "INSERT INTO lib1(Bookid, BookName, AuthorName) VALUES (?, ?, ?)";
	  PreparedStatement ps3 = con.prepareStatement(q);
	  // set the values for the query parameters
	  ps.setInt(1, 4);
	  ps.setString(2, "Wings of Fire");
	  ps.setString(3, "APJ Abdul Kalam");
	    // execute the query
		ps.executeUpdate();
		System.out.println("Data update successfully");


		//Delete method to delete the data from the table based on bookid
		String q4 = "DELETE FROM lib1 WHERE Bookid = ?";
		PreparedStatement ps4 = con.prepareStatement(q4);
		// set the value for the query parameter
		ps4.setInt(1, 6);
		// execute the query
		ps4.executeUpdate();
		System.out.println("Data delete successfully");

		  //Update method to update data in the table based on bookid		       
		       String q5 = "UPDATE lib1 SET BookName=?, AuthorName=? WHERE Bookid=?";
		        PreparedStatement ps5 = con.prepareStatement(q5);
		        // set the values for the query parameters
		        ps5.setString(1, "As You Like It");
		        ps5.setString(2, "Shakespeare");
		        ps5.setInt(3, 3);
		        ps5.executeUpdate();
		        System.out.println("Data updated successfully");
       
		        
		        //  select method to view all the data in the table.
			        String q8 = "SELECT * FROM lib1";
			        Statement s = con.createStatement();

			        // execute the query and retrieve the result set
			        ResultSet rs = s.executeQuery(q);

			        // print the result set
			        System.out.println("Bookid\tBookName\tAuthorName");
			        while (rs.next()) {
			            int bookId = rs.getInt("Bookid");
			            String bookName = rs.getString("BookName");
			            String authorName = rs.getString("AuthorName");

			            System.out.println(bookId + "\t" + bookName + "\t" + authorName);
			        }			        
			}
}


