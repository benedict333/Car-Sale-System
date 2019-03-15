package com.controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HomeServlet() {
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
			String fileName = path+"UsedCar_List.txt";		

			try {
				Scanner scanner = new Scanner(new File(fileName));
				StringBuilder importCarList = new StringBuilder();

				while(scanner.hasNext()) {

					importCarList.append(scanner.nextLine());						

					//convert the string into an arraylist

					String str=importCarList.toString();					
					ArrayList<String> importedCarList= new ArrayList<String>(Arrays.asList(str.split("%")));
					for(int i=0; i<importedCarList.size(); i++)
					{
						Car list1 = new Car();
						String line = importedCarList.get(i);
						String [] parseLine = line.split("_");		
						list1.setLicense(parseLine[0]);		
						list1.setMake(parseLine[1]);		
						list1.setBodyType(parseLine[2]);
						list1.setColor(parseLine[3]);
						list1.setYear(parseLine[4]);
						list1.setMiles(parseLine[5]);
						
						list1.setOldPrice(Double.valueOf(parseLine[6]));						
						list1.setDiscount(Double.valueOf(parseLine[7]));
						list1.setNewPrice(Double.valueOf(parseLine[8]));
						list1.setBoughtDate(parseLine[9]);

						existingCarList.add(i,list1);
						
					}
				}
			}catch(FileNotFoundException e) {
				System.out.println("Error reading file: "+fileName);

			}
			
		}
		
		
		for (int j = 0; j < existingCarList.size(); j++)
			
			{
				carFound.add(existingCarList.get(j));
			}

		session.setAttribute("existingCarList", existingCarList);
		


		//System.out.println("Car found list : "+carFound.size());
	

		RequestDispatcher rs= request.getRequestDispatcher("Home.jsp");
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
