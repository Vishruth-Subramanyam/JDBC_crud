package com.caps.jdbc;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
//import java.sql.SQLException;
//import java.util.Scanner;
import java.sql.Connection;

public class Batch {

	private static Object pstmt;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//		Scanner sc = new Scanner(System.in);
		//		System.out.println("Enter the user id");
		//		int uid= Integer.parseInt(sc.nextLine());
		//		System.out.println("enter the fname");
		//		String fname = sc.nextLine();
		//		System.out.println("enter the lname");
		//		String lname = sc.nextLine();
		//		System.out.println("enter the password");
		//		String password = sc.nextLine();
		//		sc.close();
		//		
		Connection con = null;

		//1 Load the Driver 
		try{
			Class.forName("com.mysql.jdbc.Driver"); // For 5.1.7 jar file it is just 
			// 2 Get connection via driver                     jdbc not cj.jdbc
			String dbUrl="jdbc:mysql://localhost:3306/cleveridiots_db";
			con = DriverManager.getConnection(dbUrl,"JDBC" ,"abcd" );
			// 3 Issue sql query via conncetion

			PreparedStatement pstmt = con.prepareStatement("insert into u_info values(?,?,?,?)");
			//int count = pstmt.executeUpdate();
			pstmt.setInt(1,12);
			pstmt.setString(2,"Ganguly");
			pstmt.setString(3,"Sourav");
			pstmt.setString(4, "abcde");
			pstmt.addBatch(); // 1st batch file added

			pstmt.setInt(1,13);
			pstmt.setString(2,"Joe");
			pstmt.setString(3,"Root");
			pstmt.setString(4, "abcde");
			pstmt.addBatch(); // 1st batch file added

			pstmt.setInt(1,14);
			pstmt.setString(2,"Kedhar");
			pstmt.setString(3,"Sourav");
			pstmt.setString(4, "abcde");
			pstmt.addBatch(); // 1st batch file added

			pstmt.setInt(1,15);
			pstmt.setString(2,"Hari");
			pstmt.setString(3,"Rav");
			pstmt.setString(4, "abcde");
			pstmt.addBatch(); // 1st batch file added
			// 4 Process the result
			int[] res = pstmt.executeBatch();
			int count =0;
			for(int i=0;i<res.length;++i)
			{
				count = count + res[i];

			}
			System.out.println("Number of records inserted : " +count);
		}catch(Exception e){
			e.printStackTrace();
		}
		finally
		{
			if(con != null){
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if(pstmt != null){
				try {
					((Statement) pstmt).close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}
	}

}
