package com.controllers;

import java.io.BufferedWriter;
import static java.time.temporal.ChronoUnit.DAYS;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Scanner;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.car.Car;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());

		HttpSession session = request.getSession(true);
		ArrayList<Car> carFound = new ArrayList<Car>();
		
		ArrayList<Car> existingCarList = (ArrayList<Car>)session.getAttribute("existingCarList") ;

		if (existingCarList ==null)
		{
			existingCarList = new ArrayList<Car>();
			final String path = "C:\\Users\\admin\\Desktop\\Stream\\";
			String fileName = path+"Car_List.txt";		

			try {
				Scanner scanner = new Scanner(new File(fileName));
				StringBuilder importCarList = new StringBuilder();

				while(scanner.hasNext()) {

					importCarList.append(scanner.nextLine());						

					//convert the string into an arraylist

					String str=importCarList.toString();					
					ArrayList<String> importedCarList= new ArrayList<String>(Arrays.asList(str.split("%")));
					
					DecimalFormat df = new DecimalFormat("#0.00"); 
					for(int i=0; i<importedCarList.size(); i++)
					{
						
						Car list1 = new Car();
						String line = importedCarList.get(i);
						String [] parseLine = line.split("_");
						list1.setCarType(parseLine[0]);						
						list1.setLicense(parseLine[1]);		
						list1.setMake(parseLine[2]);		
						list1.setBodyType(parseLine[3]);
						list1.setColor(parseLine[4]);
						list1.setYear(parseLine[5]);
						list1.setMiles(parseLine[6]);

						list1.setOldPrice(Double.valueOf(parseLine[7]));						
						list1.setDiscount(Double.valueOf(parseLine[8]));
						list1.setNewPrice(Double.valueOf(parseLine[9]));
						list1.setBoughtDate(parseLine[10]);

						existingCarList.add(i,list1); 
						
					}
				}
			}catch(FileNotFoundException e) {
				System.out.println("Error reading file: "+fileName);

			}

			

			for(int i=0; i<existingCarList.size(); i++)
			{			

				String inventDate = (existingCarList.get(i).getBoughtDate().trim());
				
				LocalDate today = LocalDate.now();	          

				DateTimeFormatter format = DateTimeFormatter.ofPattern("MM/dd/yyyy");
				NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);

				LocalDate date2 = LocalDate.parse(inventDate, format);
				long countDays = DAYS.between(date2, today);
				Car list2 = new Car();

				if ( countDays > 120 ) {
					Double lastPrice= (existingCarList.get(i).getOldPrice());
					Double discount = (lastPrice *10)/100;
					Double changedPrice =  lastPrice - discount;
					list2.setCarType(existingCarList.get(i).getCarType());
					list2.setLicense(existingCarList.get(i).getLicense());		
					list2.setMake(existingCarList.get(i).getMake());		
					list2.setBodyType(existingCarList.get(i).getBodyType());
					list2.setColor(existingCarList.get(i).getColor());
					list2.setYear(existingCarList.get(i).getYear());
					list2.setMiles(existingCarList.get(i).getMiles());				

					list2.setOldPriceStr(formatter.format(lastPrice));

					list2.setDiscountStr(formatter.format(discount));
					list2.setNewPriceStr(formatter.format(changedPrice));
					list2.setBoughtDate(existingCarList.get(i).getBoughtDate());
				}


				else if (countDays <=120 ){
					list2.setCarType(existingCarList.get(i).getCarType());
					list2.setLicense(existingCarList.get(i).getLicense());		
					list2.setMake(existingCarList.get(i).getMake());		
					list2.setBodyType(existingCarList.get(i).getBodyType());
					list2.setColor(existingCarList.get(i).getColor());
					list2.setYear(existingCarList.get(i).getYear());
					list2.setMiles(existingCarList.get(i).getMiles());	
					Double lastPrice1= (existingCarList.get(i).getOldPrice());
					list2.setOldPriceStr(formatter.format(lastPrice1));

					list2.setDiscountStr(null);
					list2.setNewPriceStr(null);	
					list2.setBoughtDate(existingCarList.get(i).getBoughtDate());

				}

				existingCarList.set(i, list2);

				}	
			
			}
		
		System.out.println(existingCarList.size());
			String selectedType = request.getParameter("carType");
			
			Car search1 = new Car();
			Car search2 = new Car();

			search1.setMake(request.getParameter("make"));

			System.out.println("Search query: " + search1);
			
			Double min= (Double.parseDouble(request.getParameter("minPrice")));
			Double max= (Double.parseDouble(request.getParameter("maxPrice")));
			search2.setMinPrice(min);
			search2.setMaxPrice(max);
			
			System.out.println("Search query: " + search2);
			
						
			for (int j = 0; j < existingCarList.size(); j++)				
				
			{										
				String priceFound= (existingCarList.get(j).getOldPriceStr().toString());
				String replaceString1 = priceFound.replace("$","").replace(",", "");
				Double value1= Double.valueOf(replaceString1);
								
				if (existingCarList.get(j).toString().contains(selectedType) && existingCarList.get(j).toString().contains(search1.getMake().trim()) &&
						search2.getMinPrice() <= value1 && search2.getMaxPrice() >=value1)
				{

					carFound.add(existingCarList.get(j));
				}
			
				
				
		}
		session.setAttribute("existingCarList", existingCarList);
		session.setAttribute("carFound", carFound);	


		System.out.println("Car found list : "+carFound.size());



		RequestDispatcher rs= request.getRequestDispatcher("SearchCar.jsp");
		rs.forward(request, response);


	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
