package com.caps.jdbc;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.sql.Statement;
import java.util.Scanner;



public class CallableStatementExample {


	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		int count=0;
		try {
			/*
			 * 1. Load the Driver
			 */
			java.sql.Driver driverRef = new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(driverRef);
			// class.forName("com.mysql.cj.jdbc.Driver") can also be used to load
							// the class
			
			/*
			 * 2. Get the DB Connection via Driver
			 */ //First way of getting connection 
						String dbUrl="jdbc:mysql://localhost:3306/cleveridiots_db"
								+ "?user=JDBC&password=abcd";
						
			con = DriverManager.getConnection(dbUrl);
			
			/*
			 * 3. Issue the SQL query via connection
			 */
			System.out.println("mysql :");
			Scanner sc = new Scanner(System.in);
			String sql = sc.nextLine();
			sc.close();
			stmt = con.createStatement();
			boolean state = stmt.execute(sql);
					if(state)
					{
						
						rs= stmt.getResultSet();
						while(rs.next()){
							int userid = rs.getInt(1);
							String firstname = rs.getString(2);
							String lastname = rs.getString(3);
							String passwd = rs.getString(4);

							
							System.out.println(userid);
							System.out.println(firstname);
							System.out.println(lastname);
							System.out.println(passwd);
							System.out.println("*********************");

					}}else
					{
						 count = stmt.getUpdateCount();
						if(count > 0)
						{
							System.out.println(count + " Row affected");
						}
			}    
			// 4. Process the results
			 



		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			
			 

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
	}

}