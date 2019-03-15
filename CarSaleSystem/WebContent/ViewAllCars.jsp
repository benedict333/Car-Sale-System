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
		<a class="active"  href="#ViewAllCars">View All Cars</a>
		 <a href="SellCar.jsp">Sell My Car</a>
		 <a  href="AddCarsToInventory.jsp">Add to Inventory</a> 
		  <a href="Report.jsp">Inventory Report</a>
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
	<div class="container-pic">

		 <img border="0" src="images/view-all-cars.jpg" alt="Photo of the car"  width = 2500px  height= 200px />
	</div>
	
	<h6>
		Hello
		<c:forEach items="${newUserList}" var="newUser">
		
		<c:out value="${newUser.userName}" />
		
		
		</c:forEach>
	</h6>
	
    <c:if test="${existingCarList!=null}">
		<c:choose>

			<c:when test="${existingCarList.size()>0}">
				<h5>Here are the available cars:-</h5>

				<c:forEach items="${existingCarList}" var="myCar">
					<table class="table-outer">
						<tbody>
							<tr>
								<td>

									<table class="inner-table">
										<tbody>
											<tr>
											
												<td class="picture"><img border="0"
													src="${myCar.license}"
													alt="<c:out value="${myCar.license}"/>" width="500"
													height="330"></td>

												<td class="details">

													<table class="car-details">
														<tr class="heading">
															<th><h5>Car Type</h5></th>
															<th><h5>Make</h5></th>
															<th><h5>Body Type</h5></th>
															<th><h5>Color</h5></th>
															<th><h5>Year of Manufacture</h5></th>
															<th><h5>No. of Miles Run</h5></th>
														</tr>
														<tbody>


															<tr class="details">
																<td><h6>
																		<c:out value="${myCar.carType}" />
																	</h6></td>

																<td><h6>
																		<c:out value="${myCar.make}" />
																	</h6></td>


																<td><h6>
																		<c:out value="${myCar.bodyType}" />
																	</h6></td>

																<td><h6>
																		<c:out value="${myCar.color}" />
																	</h6></td>


																<td><h6>
																		<c:out value="${myCar.year} " />
																	</h6></td>

																<td><h6>
																		<c:out value="${myCar.miles}" />
																	</h6></td>
															</tr>
														</tbody>
													</table>



													<table class="table-nested">
														<tbody>
															<c:if test="${myCar.newPriceStr != null }">
																<tr>
																	
																	<td><h2>Offer Price:
																			<c:out value="${myCar.newPriceStr}" />
																		</h2></td>
																</tr>


																<tr>
																	
																	<td><h2>You Save
																			<c:out value="${myCar.discountStr}" />
																		</h2></td>
																</tr>

																<tr>
																	
																	<td><h4> Actual Price:
																			<span class="line-through"><c:out value="${myCar.oldPriceStr}" /> </span>
																		</h4></td>
																</tr>												
																
														</tbody>
													</table>
																
																
															</c:if>
															
															<table class="table-oldprice">
														<tbody>

															<c:if test="${myCar.newPriceStr == null }">

																<tr>
																	
																	<td><h2>Price: 
																			<c:out value="${myCar.oldPriceStr}" />
																		</h2></td>
																</tr>
																
																
																
															</c:if>
															
															
														</tbody>
													</table>	
															

												</td>

												<td width="70%" class = "buy">
												
													<a href="SoldServlet?id=${myCar.license.trim()}"> <img border="5px"
													src="images/buy-now1.gif" width="150"
													height="100"></a>
												</td>
											</tr>
											
											</tbody>
													</table>															
											
										</tbody>
									</table>
								
							</td>	
							</tr>
						</tbody>
					</table>

				</c:forEach>
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