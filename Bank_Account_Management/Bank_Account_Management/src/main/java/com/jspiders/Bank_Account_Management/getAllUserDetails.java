package com.jspiders.Bank_Account_Management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.Scanner;

public class getAllUserDetails {
	Scanner sc=new Scanner(System.in);
	 public void fetchUserDetailsById(int id) {
		 try {
	            int Id;
	            while (true) {
	                System.out.println("Enter User ID:");
	                Id = sc.nextInt();
	                if (IdExistsindatabase(Id)) {
	                  if(getUserDetailsById(Id)){
	                    	System.out.println("Success..");
	                    }
	                  else {
	                	  System.out.println("Entered User Id Not Exists");
	                  }
	                } 
	            else {
                    System.out.println("Invalid ID. Try Again.");
	            }
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	private boolean getUserDetailsById(int id) {
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_details_system", "root", "root");

	            String query = "SELECT * FROM bank_account_details WHERE Id = ?";
	            PreparedStatement ps = con.prepareStatement(query);
	            ps.setInt(1, id);
	            ResultSet rs = ps.executeQuery();

	            if (rs.next()) {
	            	   Userdaetail1 userdaetail1=new Userdaetail1();
	            	   userdaetail1.AllUserDetails();
	            }
	        }
	            catch(Exception e) {
	            	e.printStackTrace();
	            }
			return false;
	 }
	private boolean IdExistsindatabase(int id) {
	    boolean exists = false;
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_details_system", "root", "root");
	        String query = "select * from bank_account_details where Id=?";
	        PreparedStatement ps = con.prepareStatement(query);
	        ps.setInt(1, id);
	        ResultSet rs = ps.executeQuery();
	        if (rs.next()) {
	            exists = true;
	        } else {
	            System.out.println("Enter the Correct Id");
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return exists;
	}
}
