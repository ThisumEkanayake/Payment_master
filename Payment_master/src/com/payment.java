package com;

import java.sql.*;

public class payment {
	
	private Connection connect() 
	 { 
	 Connection con = null; 
	 try
	 { 
	 Class.forName("com.mysql.jdbc.Driver"); 
	 
	 //Provide the correct details: DBServer/DBName, username, password 
	 con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/paydb", "root", ""); 
	 } 
	 catch (Exception e) 
	 { 
		 e.printStackTrace();
	 } 
	 return con; 
	 } 
	
	
	public String insertpayment(String amount, String date, String accountNo, String paymentType) 
	 { 
	 String output = ""; 
	 try
	 { 
	 Connection con = connect(); 
	 if (con == null) 
	 {return "Error while connecting to the database for inserting."; } 
	 // create a prepared statement
	 String query = " insert into paydb (`paymentID`,`amount`,`date`,`accountNo`,`paymentType`)"
	 + " values (?, ?, ?, ?, ?)"; 
	 PreparedStatement preparedStmt = con.prepareStatement(query); 
	 // binding values
	 preparedStmt.setInt(1, 0); 
	 preparedStmt.setString(2, amount); 
	 preparedStmt.setString(3, date); 
	 preparedStmt.setDouble(4, Double.parseDouble(accountNo)); 
	 preparedStmt.setString(5, paymentType); 
	 
	// execute the statement
	 preparedStmt.execute(); 
	 con.close(); 
	 
	 	String newpayments = readpayments();
	 	output = "{\"status\":\"success\", \"data\": \"" + 
	 			 newpayments + "\"}"; 
	 } 
	 catch (Exception e) 
	 { 
		 output = "{\"status\":\"error\", \"data\": \"Error while inserting the payment.\"}"; 
	 System.err.println(e.getMessage()); 
	 } 
	 return output; 
	 } 
	
	public String readpayments() 
	 { 
	 String output = ""; 
	 try
	 { 
	 Connection con = connect(); 
	 if (con == null) 
	 {return "Error while connecting to the database for reading."; } 
	 
	 // Prepare the html table to be displayed
	 output = "<table border='1'><tr><th>amount</th><th>date</th>" +
	 "<th>accountNo</th>" + 
	 "<th>paymentType</th>" +
	 "<th>Update</th><th>Remove</th></tr>"; 
	 
	 String query = "select * from paydb"; 
	 Statement stmt = con.createStatement(); 
	 ResultSet rs = stmt.executeQuery(query); 
	 
	 // iterate through the rows in the result set
	 while (rs.next()) 
	 { 
	 String paymentID = Integer.toString(rs.getInt("paymentID")); 
	 String amount = rs.getString("amount"); 
	 String date = rs.getString("date"); 
	 String accountNo = Double.toString(rs.getDouble("accountNo")); 
	 String paymentType = rs.getString("paymentType"); 
	 
	// Add into the html table
	 output += "<tr><td><input id='hidpaymentIDUpdate' name='hidpaymentIDUpdate' type='hidden' value='" + paymentID
	 + "'>" + amount + "</td>"; 
	 output += "<td>" + date + "</td>"; 
	 output += "<td>" + accountNo + "</td>"; 
	 output += "<td>" + paymentType + "</td>"; 
	 
	 
	// buttons
	 output += "<td><input name='btnUpdate' type='button' value='Update' class='btnUpdate btn btn-secondary'></td>"
			+ "<td><input name='btnRemove' type='button' value='Remove' class='btnRemove btn btn-danger' data-paymentid='"
			+ paymentID + "'>" + "</td></tr>"; 
	 } 
	 con.close(); 
	 // Complete the html table
	 output += "</table>"; 
	 } 
	 catch (Exception e) 
	 { 
	 output = "Error while reading the payments."; 
	 System.err.println(e.getMessage()); 
	 } 
	 return output; 
	 } 
	
	
	public String updatepayment(String paymentID, String amount, String date, String accountNo, String paymentType)
	{ 
		 String output = ""; 
		 try
		 { 
			 Connection con = connect(); 
		 if (con == null) 
		 {return "Error while connecting to the database for updating."; } 
		 // create a prepared statement
		 String query = "UPDATE paydb SET amount=?,date=?,accountNo=?,paymentType=? WHERE paymentID=?"; 
		 PreparedStatement preparedStmt = con.prepareStatement(query); 
		 // binding values
		 preparedStmt.setString(1, amount); 
		 preparedStmt.setString(2, date); 
		 preparedStmt.setDouble(3, Double.parseDouble(accountNo)); 
		 preparedStmt.setString(4, paymentType); 
		 preparedStmt.setInt(5, Integer.parseInt(paymentID)); 
		 // execute the statement
		 preparedStmt.execute(); 
		 con.close(); 
		 
		 String newpayments = readpayments();
		 output = "{\"status\":\"success\", \"data\": \"" + 
				 newpayments + "\"}";  
		 
		 } 
		 catch (Exception e) 
		 { 
			 output = "{\"status\":\"error\", \"data\": \"Error while updating the payment.\"}"; 
		 System.err.println(e.getMessage()); 
		 } 
		 return output; 
		 } 
	
	
	public String deletepayment(String paymentID) 
	 { 
	 String output = ""; 
	 try
	 { 
	 Connection con = connect(); 
	 if (con == null) 
	 {
		 return "Error while connecting to the database for deleting."; 
	 } 
	 // create a prepared statement
	 String query = "delete from paydb where paymentID=?"; 
	 PreparedStatement preparedStmt = con.prepareStatement(query); 
	 // binding values
	 preparedStmt.setInt(1, Integer.parseInt(paymentID)); 
	 // execute the statement
	 preparedStmt.execute(); 
	 con.close();
	 
	 String newpayments = readpayments();
	 output = "{\"status\":\"success\", \"data\": \"" + 
			 newpayments + "\"}"; 
	 } 
	 catch (Exception e) 
	 { 
		 output = "{\"status\":\"error\", \"data\": \"Error while deleting the payment.\"}"; 
	 System.err.println(e.getMessage()); 
	 } 
	 return output; 
	 } 


}
