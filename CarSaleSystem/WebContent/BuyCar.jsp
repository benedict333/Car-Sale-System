<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.car.Car"%>
<%@ page import="com.car.loginUser"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">


<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Car Sale @ St. Louis</title>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">


<title>Car Sale</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link rel="stylesheet" type="text/css" href="./styles/styles.css">

<%
	Car newUser = (Car) session.getAttribute("newUser");
%>

<script>
	$(function() {
		$("#datepicker").datepicker();
	});
</script>
<style type="text/css">
</style>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Car Sale System Login</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<style>
body {
	background-color: powderblue;
}

h1 {
	color: blue;
}

p {
	color: red;
}
</style>
</head>
<link rel="stylesheet" type="text/css" href="./styles/styles.css">
<body >
<c:forEach items="${newUserList}" var="newUser">
<div id="fixed_bar">
	<div class="topnav">
		<a  href="Home.jsp">Home</a> 
		<a 	href="SearchCar.jsp">Search for a Car</a> 
		<a  href="ViewAllCars.jsp">View All Cars</a>
		<a 	href="SellCar.jsp">Sell My Car</a>
		<a  href="AddCarsToInventory.jsp">Add to Inventory</a> 
		 <a 	href="Report.jsp">Inventory Report</a>
		 <a href="LogoutServlet?"> Log Out</a>
		     <a href="#"> <span class = "userName">  Hi <c:out value="${newUser.userName}" /> </span> </a>
	</div>
	</div>
	</c:forEach>
	<br>
	<br>
	<br>
	<br>
	<br>
	
	
	
	
	<br>	
	
	<form class="form-container" action="BillingServlet" method="post">
	
		<div class="form-group">
			<label for="firstname">First Name</label> <input type="text"
				class="form-control" name="firstname" id="exampleInputfirstname"
				placeholder="First Name">
		</div>
	
			<div class="form-group">
			<label for="lastName">Last Name</label> <input type="text"
				class="form-control" name="lastname" id="exampleInputlastName"
				placeholder="Last Name">
		</div>
		
		<div class="form-group">
			<label for="email">Email address</label> <input type="text"
				class="form-control" name="email" id="exampleInputEmail1"
				placeholder="Email">
		</div>
		
		<div class="form-group">
			<label for="phoneNumber">Phone Number</label> <input type="text"
				class="form-control" name="phonenumber" id="exampleInputphoneNumber"
				placeholder="Phone Number">
		</div>	
		
		<div class="form-group">
			<label for="address">Address</label> <input type="text"
				class="form-control" name="address" id="exampleInputaddress"
				placeholder="Address">
		</div>
		
		<div class="form-group">
			<label for="creditcard">Credit Card Information</label> <input type="text"
				class="form-control" name="creditcard" id="examplecreditcard"
				placeholder="Credit Card Information">
		</div>
		
		<div class="form-group">    

     <label for="soldDate">Date</label>
      <input type="text" class="form-control" name="solddate" id="datepicker">  
        
    </div>      

		
			<div class="checkbox">
				
			</div>
			<button type="submit" class="btn btn-default">Submit</button>
	</form>
</body>
</html>