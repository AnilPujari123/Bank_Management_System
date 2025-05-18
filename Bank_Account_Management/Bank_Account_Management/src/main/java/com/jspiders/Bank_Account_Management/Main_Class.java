package com.jspiders.Bank_Account_Management;

import java.util.Scanner;

public class Main_Class {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		User_Registration ur = new User_Registration();
		Admin_Login al=new Admin_Login();
		
		System.out.println("Enter");
		System.out.println("  1.For User Registration");
		System.out.println("  2.For Admin Login");
		System.out.println("  3.For user Login");
		
		int choice=sc.nextInt();
		switch(choice)
		{
		case 1:ur.addBankDetails();
				break;
		case 2:al.adminLogin();
				
				break;
		case 3:
	}
}
}

