package com.jspiders.Bank_Account_Management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Admin_Insert {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_details_system","root","root");
			
			String query="insert into admin_details (Admin_EmailId,Admin_Password) values(?,?)";
			
			System.out.println("Enter the Admin Email Id");
			String email=sc.next();
			
			System.out.println("Enter the password");
			String password=sc.next();
			
			
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, email);
			ps.setString(2, password);
			ps.execute();
			con.close();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
