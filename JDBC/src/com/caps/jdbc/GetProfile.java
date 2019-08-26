package com.caps.jdbc;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.Connection;

public class GetProfile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the user id");
		int uid= Integer.parseInt(sc.nextLine());
		sc.close();
		Connection con = null;
		PreparedStatement pstmt =null;
		ResultSet rs =null;
		
		//1 Load the Driver 
		try{
			Class.forName("com.mysql.jdbc.Driver"); // For 5.1.7 jar file it is just 
			// 2 Get connection via driver                     jdbc not cj.jdbc
			String dbUrl="jdbc:mysql://localhost:3306/cleveridiots_db";
			con = DriverManager.getConnection(dbUrl,"JDBC" ,"abcd" );
			// 3 Issue sql query via conncetion

			String sql = "select * from u_info where u_id= ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,uid);
			rs = pstmt.executeQuery();
			
			// 4 Process the result
			
			if(rs.next())
			{
				int userid = rs.getInt(1);
				String firstname = rs.getString(2);
				String lastname = rs.getString(3);
				String passwd = rs.getString(4);

				
				System.out.println(userid);
				System.out.println(firstname);
				System.out.println(lastname);
				System.out.println(passwd);
				System.out.println("*********************");
			
				
			}else
			{
				System.out.println("Not Found");
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
			
			if( rs!=null)
			{
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
