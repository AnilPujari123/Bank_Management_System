package com.jspiders.Bank_Account_Management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Admin_Details {
	public static void main(String[] args)  {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Bank_Details_System","root","root");
			System.out.println("Connection Established Successfully");
			Statement st=con.createStatement();
			String query = "create table admin_details (Id INT AUTO_INCREMENT primary key,Admin_EmailId varchar(20),Admin_Password varchar(20));";
			st.execute(query);
			System.out.println("Table created successfully");
			con.close();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
}
