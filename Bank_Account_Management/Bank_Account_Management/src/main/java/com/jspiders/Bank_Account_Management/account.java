package com.jspiders.Bank_Account_Management;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;
import java.util.Scanner;

public class account {
	    Scanner sc = new Scanner(System.in);

	    public void acceptAdminDetails(int id) {
	        try {
	            if (IdExistsInDatabase(id)) {
	                String accountNumber = generateUniqueAccountNumber();
	                String pin = generateUniquePin();

	                if (storeBankDetails(id, accountNumber, pin)) {
	                	Accept accept=new Accept();
  	                	String accountNumber1 = accept.generateAccountNumber();
  	                    String pin1 =accept. generatePin();
	                    System.out.println("Account Number: " + accountNumber1);
	                    System.out.println("PIN: " + pin1);
	                } else {
	                    System.out.println("Error storing details. Try again.");
	                }
	            } else {
	                System.out.println("Invalid ID. Try Again.");
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    private boolean IdExistsInDatabase(int id) {
	        boolean exists = false;
	        try {
	            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_details_system", "root", "root");
	            String query = "SELECT * FROM bank_account_details WHERE Id=?";
	            PreparedStatement ps = con.prepareStatement(query);
	            ps.setInt(1, id);
	            ResultSet rs = ps.executeQuery();
	            exists = rs.next();
	            con.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return exists;
	    }

	    private String generateUniqueAccountNumber() {
	        Random random = new Random();
	        String accountNumber1;
	        do {
	            accountNumber1 = String.valueOf(1000000 + random.nextInt(9000000)); // Generates a 7-digit number
	        } while (accountExistsInDatabase(accountNumber1));
	        return accountNumber1;
	    }

	    private String generateUniquePin() {
	        Random random = new Random();
	        return String.valueOf(1000 + random.nextInt(9000)); // Generates a 4-digit PIN
	    }

	    private boolean accountExistsInDatabase(String accountNumber) {
	        boolean exists = false;
	        try {
	            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_details_system", "root", "root");
	            String query = "SELECT * FROM bank_account_details WHERE AccountNumber=?";
	            PreparedStatement ps = con.prepareStatement(query);
	            ps.setString(1, accountNumber);
	            ResultSet rs = ps.executeQuery();
	            exists = rs.next();
	            con.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return exists;
	    }

	    private boolean storeBankDetails(int id, String accountNumber, String pin) {
	        boolean success = false;
	        try {
	            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_details_system", "root", "root");
	            String query = "INSERT INTO bank_account_details (Id, AccountNumber, Pin) VALUES (?, ?, ?)";
	            PreparedStatement ps = con.prepareStatement(query);
	            ps.setInt(1, id);
	            ps.setString(2, accountNumber);
	            ps.setString(3, pin);
	            success = ps.executeUpdate() > 0;
	            con.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return success;
	    }
}
