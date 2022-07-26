package com.saurabh.demo;

import java.sql.*;
public class Demo {

	public static void main(String[] args) throws Exception {
		try {
			//load the drivers ;
			
			
			// make a connection ;
			// creating a new data bases by using Create new databases jdbc;
			String url = "jdbc:mysql://localhost:3306/jdbc";
			String username = "root";
			String password = "root";
			String query = "select FirstName from Persons where FirstName = 'saurabh' ";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url, username, password);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			rs.next();
			String name = rs.getString("FirstName");
			System.out.println(name);
			stmt.close();
			rs.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
