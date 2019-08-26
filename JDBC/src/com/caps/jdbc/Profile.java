package com.caps.jdbc;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.sql.SQLException;
import java.util.Scanner;
import java.sql.Connection;

public class Profile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the user id");
		int uid= Integer.parseInt(sc.nextLine());
		System.out.println("enter the fname");
		String fname = sc.nextLine();
		System.out.println("enter the lname");
		String lname = sc.nextLine();
		System.out.println("enter the password");
		String password = sc.nextLine();
		sc.close();
		Connection con = null;
		PreparedStatement pstmt =null;
		//1 Load the Driver 
		try{
			Class.forName("com.mysql.jdbc.Driver"); // For 5.1.7 jar file it is just 
			// 2 Get connection via driver                     jdbc not cj.jdbc
			String dbUrl="jdbc:mysql://localhost:3306/cleveridiots_db";
			con = DriverManager.getConnection(dbUrl,"JDBC" ,"abcd" );
			// 3 Issue sql query via conncetion

			String sql = "insert into u_info values(?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,uid);
			pstmt.setString(2, fname);
			pstmt.setString(3,lname);
			pstmt.setString(4, password);

			int count = pstmt.executeUpdate();
			// 4 Process the result
			if(count > 0 )
			{
				System.out.println("Profile Createed");
			}else
			{
				System.out.println("Profile not created");
			}
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
					pstmt.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
					
		}
	}

}
