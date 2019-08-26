package com.caps.jdbc;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.Connection;

public class Upadte {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the user id");
		int uid= Integer.parseInt(sc.nextLine());
		System.out.println("Enter the previous password");
		String oldpass = sc.nextLine();
		System.out.println("Enter the new password");
		String newpass = sc.nextLine();
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

			String sql = "Update u_info set password=? where password=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, newpass);
			pstmt.setString(2, oldpass);
			int count = pstmt.executeUpdate();
			if(count > 0)
			{
				System.out.println("Updated successfully !!");
					}
				else
			{
				System.out.println("Not Updated");
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
