package com.caps.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;



public class MyFirstJDBC2 {


	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			/*
			 * 1. Load the Driver
			 */
			java.sql.Driver driverRef = new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(driverRef);
			System.out.println("Driver Loaded...");
			// class.forName("com.mysql.cj.jdbc.Driver") can also be used to load
							// the class
			
			/*
			 * 2. Get the DB Connection via Driver
			 */ //First way of getting connection 
						String dbUrl="jdbc:mysql://localhost:3306/cleveridiots_db";
			// Second way of connecting		
Scanner sc = new Scanner(System.in);
		System.out.println("User :");
		String username= sc.nextLine();
		System.out.println("Password :");
		String password = sc.nextLine();
		con = DriverManager.getConnection(dbUrl, username, password);
		sc.close();
		
			System.out.println("Connected...");
			
			/*
			 * 3. Issue the SQL query via connection
			 */
			String sql = "select * from u_info";

			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);

			/*
			 * 4. Process the results
			 */

			while(rs.next()){
				int userid = rs.getInt("u_id");
				String firstname = rs.getString("fname");
				String lastname = rs.getString("lname");
				String passwd = rs.getString("password");

				System.out.println(userid);
				System.out.println(firstname);
				System.out.println(lastname);
				System.out.println(passwd);
				System.out.println("*********************");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			/*
			 * 5. Close all the JDBC Objects
			 */

			if(con != null){
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(stmt != null){
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(rs != null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}
	}//end of main

}//End of Class