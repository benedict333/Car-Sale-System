<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.car.Car"%>
<%@ page import="com.car.loginUser"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<%Car option1 = new Car();
%>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Car Sale @ St. Louis</title>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">

<title>Car Sale</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link rel="stylesheet" type="text/css" href="./styles/styles.css">



<script>
	$(function() {
		$("#datepicker").datepicker();
	});
</script>
<style type="text/css">
</style>
</head>
<body>
<c:forEach items="${newUserList}" var="newUser">
	<div id="fixed_bar">
		<div class="topnav">
			<a href="Home.jsp">Home</a>
			 <a href="SearchCar.jsp">Search for a Car</a>
		<a  href="ViewAllCars.jsp">View All Cars</a>
		 <a href="SellCar.jsp">Sell My Car</a> 
		 <a  href="AddCarsToInventory.jsp">Add to Inventory</a> 
		 <a class="active" 	href="#Report">Inventory Report</a>
		  <a href="LogoutServlet?"> Log Out</a>
		    <a href="#"> <span class = "userName">  Hi <c:out value="${newUser.userName}" /> </span> </a>
		</div>
	</div>
	</c:forEach>
	<br>
	<br>
	<br>
	<br>


	
			<div class="report">
				<h6>Please choose any of the following options to generate the
					inventory report</h6>

				

					<h5><a href="RecordServlet?id=soldByDate"> 
					Sold Cars Report - Transaction
						by date </a></h5>
						<h5><a href="AvailableCarsServlet?id=carsAvailable">Available Cars in the
						inventory - dealership's purchase by date</a></h5>
									
			</div>
		
	

	<c:if test="${soldRecord !=null}">

		<c:choose>

			<c:when test="${soldRecord.size()>0}">
				<h2>
					Total no. of cars sold:
					<c:out value="${soldRecord.size()}" />
				</h2>



<table class="report" id="t01">
  <tr>
    <th><h2>Car-Details</h2></th>						
    <th><h2>Customer-Details</h2></th> 
    <th><h2>Date of Sale</h2></th>
  </tr>
  
  <tr>
  <c:forEach items="${soldRecord}" var="myCar">
    <td>
    
				<table class="table-carReport">
						
										<tr>
										
											<td><h6>Car Type:</h6></td>
											<td><h6>
													<c:out value="${myCar.carType}" />
												</h6></td>

										</tr>
											<td><h6>Car ID</h6></td>
											<td><h6>
													<c:out value="${myCar.license}" />
												</h6></td>
										<tr>
											<td><h6>Selling Price:</h6></td>
											<td><h6>
													<c:out value="${myCar.newPriceStr}" />
												</h6></td>

										</tr>
										<tr>

											<td><h6>Actual Price:</h6></td>
											<td><h6>
													<c:out value="${myCar.oldPriceStr}" />
												</h6></td>
										</tr>

										<tr>
											<td><h6>Discount</h6></td>
											<td><h6>
													<c:out value="${myCar.discountStr}" />
												</h6></td>

										</tr>

										<tr>
											<td><h6>Make:</h6></td>
											<td><h6>
													<c:out value="${myCar.make}" />
												</h6></td>

										</tr>


										<tr>
											<td><h6>Body Type:</h6></td>
											<td><h6>
													<c:out value="${myCar.bodyType}" />
												</h6></td>
										</tr>

										<tr>
											<td><h6>Color:</h6></td>
											<td><h6>
													<c:out value="${myCar.color}" />
												</h6></td>
										</tr>

										<tr>
											<td><h6>Year of Manufacture:</h6></td>
											<td><h6>
													<c:out value="${myCar.year} " />
												</h6></td>
										</tr>

										<tr>
											<td><h6>No. of Miles Run:</h6></td>
											<td><h6>
													<c:out value="${myCar.miles}" />
												</h6></td>
										</tr>
										<tr>
											<td><h6>Car received at the shop:</h6></td>
											<td><h6>
													<c:out value="${myCar.boughtDate}" />
												</h6></td>
										</tr>
								</table>
								
</td>
   
 <td>  			 		
   			 		
								<table class="table-report-1">
									<tr>
										<td><h6>First Name:</h6></td>
										<td><h6><c:out value="${myCar.user.firstname}" />
											</h6></td>
									</tr>
									<tr>

										<td><h6>Last Name:</h6></td>
										<td><h6>
												<c:out value="${myCar.user.lastName}" />
											</h6></td>
									</tr>


									<tr>
										<td><h6>Email</h6></td>
										<td><h6>
												<c:out value="${myCar.user.email}" />
											</h6></td>

									</tr>

									<tr>
										<td><h6>Phone Number</h6></td>
										<td><h6>
												<c:out value="${myCar.user.phoneNumber}" />
											</h6></td>

									</tr>


									<tr>
										<td><h6>Address:</h6></td>
										<td><h6>
												<c:out value="${myCar.user.address}" />
											</h6></td>
									</tr>
									<tr>
										<td><h6>Credit Card:</h6></td>
										<td><h6>
												<c:out value="${myCar.user.creditcard}" />
											</h6></td>
									</tr>
									</table>
									
  			</td> 
  
      <td><h6><c:out value="${myCar.user.soldDate}" /></h6></td>
    
  </tr>

</c:forEach>					
							
</table>				
			</c:when>
			
						
			<c:otherwise>
				<h2>No Result!</h2>
			</c:otherwise>
			
		</c:choose>


	</c:if>

	<br>
	<br>
	<br>

</body>
</html>