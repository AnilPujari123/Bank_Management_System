package com.jspiders.Bank_Account_Management;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Admin_Login {
	Scanner sc=new Scanner(System.in);
	public void adminLogin() {
		try {
			String EmailId;
		while(true) {
			System.out.println("Enter the EmailId");
			EmailId=sc.next();
			if(emailexistsindatabase(EmailId)) {
				System.out.println("Successfull..");
				break;
			}
			else {
				System.out.println("Enter the valid email");
			}
		}
		String password;
		while(true) {
			System.out.println("Enter the password");
			password=sc.next();
			if(passwordexistsdatabase(password)) {
				System.out.println("Successfull...");
				break;
			}
			else {
				System.out.println("Enter the valid Password");
			}
			
		}
		
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Enter");
		System.out.println("1.To Get All User Details");
		System.out.println("  2.To Get All Account Request Details");
		System.out.println("    3.To Get All Account Closing Request Details");
		
		
		int choice=sc.nextInt();
		switch (choice) {
		case 1:
			
			getAllUserDetails gaud=new getAllUserDetails();
			gaud.fetchUserDetailsById(choice);
			break;
			
		case 2:break;
		case 3:System.out.println("Enter EmailId");
		System.out.println("Enter Pin Number");
		
		
		break;
		default:
			break;
		}
		
	}
	
	
	private boolean passwordexistsdatabase(String password) throws ClassNotFoundException, SQLException {
		boolean exists=false;
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_details_system","root","root");
		String query="select admin_password from admin_details where admin_password=?";
		PreparedStatement ps=con.prepareStatement(query);
		ps.setString(1, password);
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			exists=true;
		}
		return exists;
	}
	public static boolean emailexistsindatabase(String email) throws ClassNotFoundException, SQLException {
		boolean exists= false;

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_details_system","root","root");
		String query="select admin_emailid from admin_details where admin_emailid=?";
		PreparedStatement ps=con.prepareStatement(query);
		ps.setString(1, email);
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			exists=true;
			con.close();
		}
		return exists;
		
	}
	
}
