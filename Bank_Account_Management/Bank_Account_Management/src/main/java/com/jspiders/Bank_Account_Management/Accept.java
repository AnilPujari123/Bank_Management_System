package com.jspiders.Bank_Account_Management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;
import java.util.Scanner;

public class Accept {
	Scanner sc=new Scanner(System.in);
	getAllUserDetails allUserDetails=new getAllUserDetails();
    private static  int ACLength = 7;
    private static  int pinlength = 4;

    public String generateAccountNumber() {
        Random random = new Random();
        StringBuilder accountNumber = new StringBuilder(ACLength);
        for (int i = 0; i < ACLength; i++) {
            int digit = random.nextInt(10);
            accountNumber.append(digit);
        }
        return accountNumber.toString();
    }

    public String generatePin() {
        Random random = new Random();
        StringBuilder pin = new StringBuilder(pinlength);
        for (int i = 0; i < pinlength; i++) {
            int digit = random.nextInt(10);
            pin.append(digit);
        }
        return pin.toString();
    }
    
   

    public void accept() {
  
            String accountNumber = generateAccountNumber();
            String pin = generatePin();
            int id=sc.nextInt();
			
            	 try {
                 	
                 	Class.forName("com.mysql.cj.jdbc.Driver");
                 	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_details_system","root","root");
                 	String query="insert into bank_account_details (Pin,AccountNumber) values (?,?)";
                 	PreparedStatement ps=con.prepareStatement(query);
                 	
                 	ps.setString(1, pin);
                 	ps.setString(2, accountNumber);
                 	ps.executeUpdate();
                 	
                 	con.close();
                    
                 } catch (Exception e) {
                     e.printStackTrace();
                 }
       
    }
    
//    public static void main(String[] args) {
//		Accept a=new Accept();
//		a.accept();
//	}
}
