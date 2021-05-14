<%@page import="com.payment"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>payments Management</title>
<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery-3.2.1.min.js"></script>
<script src="Components/payments.js"></script>
</head>
<body> 
<div class="container"><div class="row"><div class="col-6"> 
<h1>payments Management V10.1</h1>
<form id="formpayment" name="formpayment">
 amount: 
 <input id="amount" name="amount" type="text" 
 class="form-control form-control-sm">
 <br> date: 
 <input id="date" name="date" type="text" 
 class="form-control form-control-sm">
 <br> accountNo: 
 <input id="accountNo" name="accountNo" type="text" 
 class="form-control form-control-sm">
 <br> paymentType: 
 <input id="paymentType" name="paymentType" type="text" 
 class="form-control form-control-sm">
 <br>
 <input id="btnSave" name="btnSave" type="button" value="Save" 
 class="btn btn-primary">
 <input type="hidden" id="hidpaymentIDSave" 
 name="hidpaymentIDSave" value="">
</form>
<div id="alertSuccess" class="alert alert-success"></div>
<div id="alertError" class="alert alert-danger"></div>
<br>
<div id="divpaymentsGrid">
 <%
 	payment paymentObj = new payment(); 
  out.print(paymentObj.readpayments());
 %>
</div>
</div> </div> </div> 
</body>
</html>