package com.saurabh.demo;

import java.sql.*;

public class Preparedstatement {
	public static void main(String[] args) throws Exception{
		try {
			//load the drivers ;
			
			
			// make a connection ;
			// creating a new data bases by using Create new databases jdbc;
			String url = "jdbc:mysql://localhost:3306/jdbc";
			String username = "root";
			String password = "root";
			int PersonId = 5;
			String LastName = "Maurya";
			String FirstName ="Yash";
			String Address ="Lucknow";
			String City ="Lucknow";
			String query = "insert into Persons values (?,?,?,?,?) "; // to select all the database 
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url, username, password);
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1 , PersonId);
			stmt.setString(2 , LastName);
			stmt.setString(3 , FirstName);
			stmt.setString(4, Address);
			stmt.setString(5 , City);
			int cnt = stmt.executeUpdate();
			System.out.println(cnt + " row's affected");
			
			
			stmt.close();
			con.close();
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
