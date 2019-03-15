<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.car.Car"%>
<%@ page import="com.car.loginUser"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="./styles/styles.css">

<%Car sellcar = (Car)session.getAttribute("sellcar");%>
<style>
body {background-color: powdergreen;}
h1   {color: blue;}
p    {color: red;}
</style>
</head><link rel="stylesheet" type="text/css"href="./styles/styles.css">
<body background="background.jpg">
<c:forEach items="${newUserList}" var="newUser">
<div class="topnav">
		<a class="active" href="Home.jsp">Home</a>
		 <a href="#sellCar">Sell My Car</a> 
		 <a  href="AddCarsToInventory.jsp">Add to Inventory</a>  
		 <a href="Report.jsp">Inventory Report</a>
		  <a href="LogoutServlet?"> Log Out</a>
		   <a href="#"> <span class = "userName">  Hi <c:out value="${newUser.userName}" /> </span> </a>
			
	</div>	
	<div>
	</c:forEach>
	<BR>
    <BR> 
    
	</div>		
 <h4>Thanks for your interest in selling your car! </h4>  
  <h4>Here are the details you entered: </h4>  
 <h4 style="color: orange">
		<%out.print(sellcar.getMake());%>
		<br>
		 <%out.print(sellcar.getModel());%>		
	</h4>    

</body>
</html>