package com.controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.text.SimpleDateFormat;  
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.car.Car;
import com.car.User;

/**
 * Servlet implementation class RecordServlet
 */
@WebServlet("/RecordServlet")
public class RecordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session = request.getSession(true);
		
		
		ArrayList<Car> existingCarList = (ArrayList<Car>)session.getAttribute("existingCarList") ;
		ArrayList<Car> carFound = (ArrayList<Car>)session.getAttribute("carFound") ;
		List<Car> soldRecord= new ArrayList<Car>();
		
		Car option1 = new Car();
		
		 option1.setReport(request.getParameter("id"));
		 
		 System.out.println(option1.getReport());	
			
		 
		if (option1.getReport().equals("soldByDate")||(option1.getReport().equals("discountSale")))
		{				
			
			
			final String path = "C:\\Users\\admin\\Desktop\\Stream\\";
			String fileName = path+"Sold_Car_List.txt";		

			try {
				Scanner scanner = new Scanner(new File(fileName));
				StringBuilder importCarList = new StringBuilder();

				while(scanner.hasNext()) {

					importCarList.append(scanner.nextLine());						

					//convert the string into an arraylist

					String str=importCarList.toString();					 
					 
					ArrayList<String> importedSoldCarList= new ArrayList<String>(Arrays.asList(str.split("%")));
					
					//System.out.println(importedSoldCarList.toString());
					
					for(int i=0; i<importedSoldCarList.size(); i++)
					{
												
						Car soldcar2= new Car();
						
						User soldCarUser2 = new User();
						
						String line = importedSoldCarList.get(i);
						String [] parseLine = line.split("_");	
						
						soldcar2.setLicense(parseLine[0]);			
						soldcar2.setMake(parseLine[1]);	
						soldcar2.setBodyType(parseLine[2]);	
						soldcar2.setColor(parseLine[3]);	
						soldcar2.setYear(parseLine[4]);	
						soldcar2.setMiles(parseLine[5]);	
						soldcar2.setOldPriceStr(parseLine[6]);								
						soldcar2.setDiscountStr(parseLine[7]);	
						soldcar2.setNewPriceStr(parseLine[8]);	
						soldcar2.setBoughtDate(parseLine[9]);	
						
												
						soldCarUser2.setFirstname(parseLine[10]);	
						soldCarUser2.setLastName(parseLine[11]);	
						soldCarUser2.setEmail(parseLine[12]);	
						soldCarUser2.setPhoneNumber(parseLine[13]);	
						soldCarUser2.setAddress(parseLine[14]);	
						soldCarUser2.setCreditcard(parseLine[15]);
						String date1 =(parseLine[16]);
						
						 SimpleDateFormat formatter =new SimpleDateFormat("MM/dd/yyyy");  
						Date date2 = formatter.parse(date1);
						
						soldCarUser2.setSoldDate((Date) date2);												
							
						soldcar2.setUser(soldCarUser2);
						
												
						soldRecord.add(i,soldcar2);

					}
				}
			}catch(FileNotFoundException | ParseException e) {
				System.out.println("Error reading file: "+fileName);

			}
			
			int size = soldRecord.size();
			System.out.println(size);	
			System.out.println(soldRecord);	
			for (Car car : soldRecord) {
				System.out.println(car.print1());
			}
			Collections.sort(soldRecord);
			session.setAttribute("soldRecord", soldRecord);
			
		}
		
		else if (option1.getReport().equals("carsAvailable")||(option1.getReport().equals("discountRate") 
				|| (option1.getReport().equals("boughtByDate"))))
		{
			session.setAttribute("existingCarList", existingCarList);
			session.setAttribute("option1", option1);	
		}
		

							
		session.setAttribute("carFound", carFound);	
		

		
		
		
		RequestDispatcher rs= request.getRequestDispatcher("Report.jsp");
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
