package com.jspiders.Bank_Account_Management;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class Bank_Acc_Details {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Bank_Details_System", "root", "root");
			System.out.println("Connection Established Successfully");
			Statement st= con.createStatement();
			String query="create table Bank_Account_Details (Id INT AUTO_INCREMENT primary key,"
					+ "Name varchar(15),EmailId varchar(50),Aadhar varchar(12),"
					+ "MobileNumber varchar(10),PanNumber varchar(10),Address varchar(80),"
					+ "Gender varchar(10),Amount varchar(10),Pin int(4),AccountNumber int(7),Status varchar(10))";
			st.execute(query);
			System.out.println("Table created Successfully...");
			con.close();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
