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
		<a class="active" href="#home">Home</a> 
		<a href="SearchCar.jsp">Search for a Car</a>
		<a  href="ViewAllCars.jsp">View All Cars</a>
		 <a href="SellCar.jsp">Sell My Car</a>
		 <a  href="AddCarsToInventory.jsp">Add to Inventory</a> 
		  <a href="Report.jsp">Inventory Report</a>
		   <a href="LogoutServlet?"> Log Out</a>
		    <a href="#"> <span class = "userName">  Hi <c:out value="${newUser.userName}" /> </span> </a>
	</div>
	</div>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<div class="container-pic">

		 <img border="0" src="images/car-banner.jpg" alt="Photo of the car"  width = 2050px  height= 300px />
	</div>
	
	<h6> Hello		
		
		<c:out value="${newUser.userName}" />		
		
		</c:forEach>
	</h6>
	
	<h4>Now, search for your favorite Cars!</h4>
	<br>

	
	<div class="form-group">
		<form class="form-container" action="SearchServlet" method="post">
		
		<div id="wrapper">
  <label for="carType"> <h5>Please pick a choice</h5></label>

<p>
<input type="radio" name="carType" value= "Used Car" checked> Used Car</input>
</p>
<p>
<input type="radio" name="carType" value= "New Car">New Car</input>
</p>
</div>

			<div class="form-group">
	<h5> Minimum Price</h5>

         <select class="form-control" name="minPrice">
         
           <option value=0 >---</option>
        <option value=1000>$1,000</option>
      <option value=2000>$2,000</option>
      <option value=3000>$3,000</option>
      <option value=4000>$4,000</option>
      <option value=5000>$5,000</option>
      <option value=6000>$6,000</option>
      <option value=7000>$7,000</option>
      <option value=8000>$8,000</option>
      <option value=9000>$9,000</option>
      <option value=10000>$10,000</option>
      <option value=12000>$12,000</option>
      <option value=14000>$14,000</option>
      <option value=16000>$16,000</option>
      <option value=18000>$18,000</option>
      <option value=20000>$20,000</option>
      <option value=22000>$22,000</option>
      <option value=24000>$24,000</option>
      <option value=26000>$26,000</option>
      <option value=28000>$28,000</option>
      <option value=30000>$30,000</option>
      <option value=35000>$35,000</option>
      <option value=40000>$40,000</option>
      <option value=45000>$45,000</option>
      <option value=50000>$50,000</option>
      <option value=55000>$55,000</option>
      <option value=60000>$60,000</option>
      <option value=65000>$65,000</option>
      <option value=70000>$70,000</option>
      <option value=75000>$75,000</option>
      <option value=80000>$80,000</option>
      <option value=85000>$85,000</option>
      <option value=90000>$90,000</option>
      <option value=95000>$95,000</option>
      <option value=100000>$100,000</option>
      <option value=110000>$110,000</option>
      <option value=120000>$120,000</option>
      <option value=130000>$130,000</option>
      <option value=140000>$140,000</option>
      <option value=150000>$150,000</option>
      <option value=160000>$160,000</option>
      <option value=170000>$170,000</option>
      <option value=180000>$180,000</option>
      <option value=190000>$190,000</option>
      <option value=200000>$200,000</option>


            </select>
          </div>
        <div class="form-group">  
          <h5>Maximum Price </h5> 
           <select class="form-control" name="maxPrice">
      <option value=1000>$1,000</option>
      <option value=2000>$2,000</option>
      <option value=3000>$3,000</option>
      <option value=4000>$4,000</option>
      <option value=5000>$5,000</option>
      <option value=6000>$6,000</option>
      <option value=7000>$7,000</option>
      <option value=8000>$8,000</option>
      <option value=9000>$9,000</option>
      <option value=10000>$10,000</option>
      <option value=12000>$12,000</option>
      <option value=14000>$14,000</option>
      <option value=16000>$16,000</option>
      <option value=18000>$18,000</option>
      <option value=20000>$20,000</option>
      <option value=22000>$22,000</option>
      <option value=24000>$24,000</option>
      <option value=26000>$26,000</option>
      <option value=28000>$28,000</option>
      <option value=30000>$30,000</option>
      <option value=35000>$35,000</option>
      <option value=40000>$40,000</option>
      <option value=45000>$45,000</option>
      <option value=50000>$50,000</option>
      <option value=55000>$55,000</option>
      <option value=60000>$60,000</option>
      <option value=65000>$65,000</option>
      <option value=70000>$70,000</option>
      <option value=75000>$75,000</option>
      <option value=80000>$80,000</option>
      <option value=85000>$85,000</option>
      <option value=90000>$90,000</option>
      <option value=95000>$95,000</option>
      <option value=100000>$100,000</option>
      <option value=110000>$110,000</option>
      <option value=120000>$120,000</option>
      <option value=130000>$130,000</option>
      <option value=140000>$140,000</option>
      <option value=150000>$150,000</option>
      <option value=160000>$160,000</option>
      <option value=170000>$170,000</option>
      <option value=180000>$180,000</option>
      <option value=190000>$190,000</option>
      <option value=200000>$200,000</option> 

            </select>
          </div>
					
			
			<h5>Make</h5>
			<select class="form-control" name="make">
				<option value="Audi">Audi</option>
				<option value="BMW">BMW</option>
				<option value="Buick">Buick</option>
				<option value="Cadillac">Cadillac</option>
				<option value="Chevrolet">Chevrolet</option>
				<option value="Chrysler">Chrysler</option>
				<option value="Dodge">Dodge</option>
				<option value="FIAT">FIAT</option>
				<option value="Ford">Ford</option>
				<option value="GMC">GMC</option>
				<option value="Honda">Honda</option>
				<option value="Hyundai">Hyundai</option>
				<option value=Jaguar>Jaguar</option>
				<option value=m32>Jeep</option>
				<option value="Kia">Kia</option>
				<option value="LandRover">Land Rover</option>
				<option value="Lexus">Lexus</option>
				<option value="Lincoln">Lincoln</option>
				<option value="Maserati">Maserati</option>
				<option value="Mitsubishi">Mitsubishi</option>
				<option value="Nissan">Nissan</option>
				<option value="Pontiac">Pontiac</option>
				<option value="Porsche">Porsche</option>
				<option value="Toyota">Toyota</option>
				<option value="Volkswagen">Volkswagen</option>
				<option value="Volvo">Volvo</option>
			</select> <br>
			<button type="submit" class="btn btn-default">Submit</button>
		</form>
	</div>

	<c:if test="${carFound!=null}">
		<c:choose>

			<c:when test="${carFound.size()>0}">
				<h3>Here are the available cars:-</h3>

				<c:forEach items="${carFound}" var="myCar">
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
															<th><h5>Make</h5></th>
															<th><h5>Body Type</h5></th>
															<th><h5>Color</h5></th>
															<th><h5>Year of Manufacture</h5></th>
															<th><h5>No. of Miles Run</h5></th>
														</tr>
														<tbody>


															<tr class="details">

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
																	
																	<td><h3> Actual Price:
																			<span class="line-through"><c:out value="${myCar.oldPriceStr}" /> </span>
																		</h3></td>
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
													src="images/buy-now3.gif" width="200"
													height="150"></a>

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