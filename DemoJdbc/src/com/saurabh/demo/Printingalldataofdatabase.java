package com.saurabh.demo;

import java.sql.*;

public class Printingalldataofdatabase {
	public static void main(String[] args) throws Exception {
		try {
			//load the drivers ;
			
			
			// make a connection ;
			// creating a new data bases by using Create new databases jdbc;
			String url = "jdbc:mysql://localhost:3306/jdbc";
			String username = "root";
			String password = "root";
			String query = "select * from Persons  "; // to select all the database 
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url, username, password);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			String ans = "";
			while(rs.next())  // while rs.next() not getting null
			{
				ans = rs.getInt(1) + ": " + rs.getString(2) + ": " + rs.getString(3) + ": " + rs.getString(4)+ ": " + rs.getString(5);
				System.out.println(ans);
			}
			stmt.close();
			con.close();
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
