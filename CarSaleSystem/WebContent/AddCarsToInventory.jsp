<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.car.Car"%>
<%@ page import="com.car.loginUser"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Car Sale System Login</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
	$(function() {
		$("#datepicker").datepicker();
	});
</script>

<style>
body {background-color: powdergreen;}
h1   {color: blue;}
p    {color: red;}
</style>
</head><link rel="stylesheet" type="text/css"href="./styles/styles.css">
<body>
<c:forEach items="${newUserList}" var="newUser">
<div id="fixed_bar">
<div class="topnav">
		<a  href="Home.jsp">Home</a>
		<a href="SearchCar.jsp">Search for a Car</a> 
		<a  href="ViewAllCars.jsp">View All Cars</a>
		<a  href="SellCar.jsp">Sell My Car</a> 
		<a class="active" href="#AddCarsToInventry">Add to Inventory</a> 
		<a  href="Report.jsp">Inventory Report</a>
		 <a href="LogoutServlet?"> Log Out</a>
		    <a href="#"> <span class = "userName">  Hi <c:out value="${newUser.userName}" /> </span> </a>
		</div>
		</div>
		</c:forEach>
	<br>	
	<br>	
	<br>
	<h3>Please enter the details of the car	</h3>
	<br>
<form class="form-container" action="SellCarServlet" method="post">
<div id="wrapper">
  <label for="carType"> <h5>Please pick a choice</h5></label>

<p>
<input type="radio" name="carType" value= "Used Car" checked> Used Car</input>
</p>
<p>
<input type="radio" name="carType" value= "New Car" > New Car</input>
</p>
</div>
<div class="form-group">
Make <select class="form-control" name="make">				 
	<option value= "Audi">Audi</option> <option value= "BMW"  >BMW</option> <option value= "Buick"   >Buick</option> 
	<option value= "Cadillac" >Cadillac</option> 	<option value= "Chevrolet"   >Chevrolet</option>
	 <option value= "Chrysler"  >Chrysler</option> 	<option value= "Dodge"   >Dodge</option> <option value= "FIAT"  >FIAT</option> 
	 <option value= "Ford"  >Ford</option> <option value= "GMC"  >GMC</option> <option value= "Honda" >Honda</option> 
	 <option value="Hyundai" >Hyundai</option>  <option value= Jaguar  >Jaguar</option> <option value=m32   >Jeep</option> 
	 <option value="Kia"   >Kia</option> <option value= "LandRover"> Land Rover</option> <option value= "Lexus"  >Lexus</option> 
	 <option value= "Lincoln"  >Lincoln</option> <option value= "Maserati"   >Maserati</option>
	  <option value= "Mitsubishi"  >Mitsubishi</option> <option value= "Nissan"   >Nissan</option> 
	  <option value= "Pontiac"  >Pontiac</option> <option value= "Porsche"  >Porsche</option> 
<option value= "Toyota" >Toyota</option> <option value= "Volkswagen" >Volkswagen</option> <option value= "Volvo"  >Volvo</option> 
		</select>	
		 		  
				<br>
Select Body Style<select class="form-control" name="bodyType">

    <option value="Sedan">Sedan</option>
    <option value="Crossover">SUV / Crossover</option>
    <option value="Hatchback">Hatchback</option>
    <option value="Convertible">Convertible</option>
    <option value="Van">Van</option>
    <option value="Minivan">Minivan</option>
    <option value="Pickup Truck">Pickup Truck</option>
    <option value="Coupe">Coupe</option>
    <option value="Wagon">Wagon</option> 
</select>
 </div> 
    <div class="form-group">
      <label for="license">License </label>
      <input type="text" class="form-control" name="license" id="license" placeholder="License ">
    </div>    
     
     <div class="form-group">
      <label for="color">Color</label>
      <input type="text" class="form-control" name="color" id="color" placeholder="Color">
    </div>    
      
  <div class="form-group">
      <label for="year">Year</label>
      <input type="text" class="form-control" name="year" id="license" placeholder="Year">
    </div>
     <div class="form-group">
      <label for="miles">Miles</label>
      <input type="text" class="form-control" name="miles" id="miles" placeholder="Miles">
    </div> 
    
    <div class="form-group">
      <label for="price">Price</label>
      <input type="text" class="form-control" name="price" id="price" placeholder="Price">
    </div>   
    
    <div class="form-group">
    

     <label for="boughtDate">Date</label>
      <input type="text" class="form-control" name="boughtDate" id="datepicker">  
        
    </div>      
          
       <button type="submit" class = "btn btn-default">Submit</button>
       </form>       
      
      
</body>
</html>