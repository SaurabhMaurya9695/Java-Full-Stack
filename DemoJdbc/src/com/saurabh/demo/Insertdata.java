package com.saurabh.demo;

import java.sql.*;
public class Insertdata {

	public static void main(String[] args) throws Exception {
		
		try {
			//load the drivers ;
			
			
			// make a connection ;
			// creating a new data bases by using Create new databases jdbc;
			String url = "jdbc:mysql://localhost:3306/jdbc";
			String username = "root";
			String password = "root";
			String query = "insert into Persons values (4 ,  'Jaiswal' , 'Vikas' , 'Lucknow' , 'Lucknow');  "; // to select all the database 
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url, username, password);
			Statement stmt = con.createStatement();
			int cnt = stmt.executeUpdate(query);
			System.out.println(cnt + " row's affected");
			
			
			stmt.close();
			con.close();
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
