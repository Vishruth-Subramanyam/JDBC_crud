package com.caps.jdbc;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.sql.SQLException;
import java.util.Scanner;
import java.sql.Connection;

public class DeleteProfile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the user id");
		int uid= Integer.parseInt(sc.nextLine());
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

			String sql = "delete from u_info where u_id= ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,uid);
			
			int count = pstmt.executeUpdate();
			// 4 Process the result
			if(count > 0 )
			{
				System.out.println("Row Deleted");
			}else
			{
				System.out.println("Row not Deleted");
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
