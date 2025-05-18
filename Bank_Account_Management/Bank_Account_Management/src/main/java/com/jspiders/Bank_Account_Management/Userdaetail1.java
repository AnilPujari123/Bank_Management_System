package com.jspiders.Bank_Account_Management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Userdaetail1 {
	Scanner sc=new Scanner(System.in);
public void AllUserDetails() {
		
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_details_system","root","root");
		String query="select Id,Name,EmailId,Aadhar,MobileNumber,PanNumber,Address,Gender,Amount from bank_account_details";
		PreparedStatement ps=con.prepareStatement(query);
		ResultSet rs=ps.executeQuery();
		
         while (rs.next()) {
        	 int Id = rs.getInt("id");
             String Name=rs.getString("name");
             String EmailId = rs.getString("emailid");
             String Aadhar = rs.getString("aadhar");
             String MobileNumber = rs.getString("mobilenumber");
             String PanNumber = rs.getString("pannumber");
             String Address = rs.getString("address");
             String Gender = rs.getString("gender");
             String Amount = rs.getString("amount");
        	
        	   System.out.println("BankAccountDetails"+"[id="+Id+","+"name="+Name+","+" email="+EmailId+","+" aadhar="+Aadhar+","+" MobileNumber="+MobileNumber+""
                		+ " pannumber="+PanNumber+","+" Address="+Address+","+" Gender="+Gender+","+" Amount="+Amount+"]");
     
        	   System.out.println("Enter");
	                System.out.println(" 1.To Accept");
	                System.out.println("  2.To Reject");
	                int choice=sc.nextInt();
	              while(true){
  	                switch(choice) {
  	                case 1:System.out.println("Accept");
  	                	System.out.println("S.No :"+Id);
  	                	System.out.println("User Name :"+Name);
  	                	System.out.println("User EmailId:" + EmailId);
  	                	System.out.println("User Aadhar Number:"+Aadhar);
  	                	System.out.println("User Mobile Number:"+MobileNumber);
  	                	account account=new account();
  	                	account.acceptAdminDetails(Id);
  	                	System.out.println("**---**----------****----------*******------");
  	                	getAllUserDetails details=new getAllUserDetails();
  	                	details.fetchUserDetailsById(Id);
	                	break;
	                case 2: System.out.println("Sorry Try again After few Days");
	                break;
//	                default :System.out.println("Enter the Correct Id");
  	                }
                			                	
                }
        	
	}
	}
	catch(Exception e) {
		e.printStackTrace();
	}
}
}