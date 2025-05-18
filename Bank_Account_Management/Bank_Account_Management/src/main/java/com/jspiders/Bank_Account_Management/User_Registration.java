package com.jspiders.Bank_Account_Management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class User_Registration {
	Scanner sc=new Scanner(System.in);

	public void addBankDetails() {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_details_system", "root", "root");
				
				String query="insert into Bank_Account_Details (Name,EmailId,Aadhar,MobileNumber,PanNumber,Address,Gender,Amount) values(?,?,?,?,?,?,?,?)";
				
				System.out.println("Enter the Name");
				String name=sc.next();
				
				String email;
				while(true) {
					try {
						System.out.println("Enter the Email Id");
						email = sc.next();						
			      				if(validemailid(email)) {
								if(EmailExists(email)) {
									System.out.println("EmailId Already Exists Enter Different EmailId");
								}
								else {
									break;
								}
							}
			      				else {
			      					System.out.println("Enter the Valid EmailId");
			      				}
					} 
					catch (Exception e) {
						e.printStackTrace();
					}
				}
				
				String Aadhar;
				while(true) {
					try {
						System.out.println("Enter the Aadhar number");
					    Aadhar=sc.next();
							if(validaadhar(Aadhar)) {
							if(isAadhar(Aadhar)) {
								System.out.println("Aadhar Number Already Exists Enter Different Aadhar Number ");
							}
							else {
								break;
							}
						}
							else {
								System.out.println("Enter a valid Aadhar number");
							}
						}
						
					 catch (Exception e) {
						
						e.printStackTrace();
					}
					}
				
				String Mobilenumber;	
				while(true) {
					try {
						System.out.println("Enter the mobile number");
						 Mobilenumber = sc.next();
							if(validmobilenumber(Mobilenumber)) {
							if(MobilenumberExists(Mobilenumber)) {
								System.out.println("Mobile Number Already Exists Enter Different Mobile Number");
								}
								else {
									break;
								}
							}
								else {
									System.out.println("Enter the Valid Mobile Number");
								}
						}
					 catch (Exception e) {
						
						e.printStackTrace();
					}
					}
				
				String PanNumber;
				while(true) {
					try {
						System.out.println("Enter the Pan Number");
						 PanNumber=sc.next();
							if(validPannumber(PanNumber)) {
							if(isPanNumberExists(PanNumber)) {
								System.out.println("Pan Number Already Exists Enter Different Pan Number");
							}
							else {
								break;
							}
						}else {
							System.out.println("Enter the Valid Pan Number");
						}
						}
						
					 catch (Exception e) {
						System.out.println("Invalid Pan Number");
				
					}
				}
			
				
				System.out.println("Enter the Address");
				String address=sc.next();
				
				System.out.println("Enter the Gender");
				String gender=sc.next();
				
				System.out.println("Enter the Amount");
				int amount=sc.nextInt();
				
				PreparedStatement ps=con.prepareStatement(query);
				ps.setString(1, name);				
				ps.setString(2, email);				
				ps.setString(3, Aadhar);
				ps.setString(4, Mobilenumber);
				ps.setString(5, PanNumber);
				ps.setString(6, address);
				ps.setString(7, gender);
				ps.setInt(8, amount);
				ps.executeUpdate();
				con.close();
			}
			
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	
	
	
	
	private boolean validaadhar(String aadhar) {
		// TODO Auto-generated method stub
		return aadhar.matches("[0-9]\\d{11}");
	}


	private boolean isAadhar(String aadhar) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_details_system","root","root");
			
			PreparedStatement ps=con.prepareStatement("select * from Bank_Account_Details Where Aadhar=?");
			ps.setString(1, aadhar);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				return rs.getInt(1) > 0;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
private boolean validemailid(String email) {
		
		return email.matches("^[a-zA-Z0-9]+@gmail.com");
	}
	private boolean EmailExists(String email) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_details_system", "root", "root");
			
			PreparedStatement ps=con.prepareStatement("select * from  Bank_Account_Details where EmailId=?");
			ps.setString(1, email);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				return true;
			}
			con.close();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return false;
}

private boolean validmobilenumber(String mobilenumber) {
		
		return mobilenumber.matches("[0-9]\\d{9}");
	}
	private boolean MobilenumberExists(String mobilenumber) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_details_system","root","root");
			
			PreparedStatement ps=con.prepareStatement("select * from  Bank_Account_Details where MobileNumber=? ");
			ps.setString(1, mobilenumber);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				 return true;
			}
			con.close();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return false;
	}
	
	private boolean validPannumber(String panNumber) {
		return panNumber.matches("^[A-Z]{5}+[0-9]{4}+[A-Z]$");
	}
	private boolean isPanNumberExists(String panNumber) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_details_system", "root", "root");
			
			PreparedStatement ps=con.prepareStatement("select * from Bank_Account_Details where PanNumber=?");
			ps.setString(1, panNumber);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				return true ;
			}			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
}

