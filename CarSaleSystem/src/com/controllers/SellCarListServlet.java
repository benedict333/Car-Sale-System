package com.controllers;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.car.Car;

/**
 * Servlet implementation class SellCarListServlet
 */
@WebServlet("/SellCarListServlet")
public class SellCarListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SellCarListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String confirm = request.getParameter("confirm");
		ArrayList<Car> sellcars = (ArrayList<Car>)session.getAttribute("sellcars") ;		
	
		String fileType= (String)session.getAttribute("filetype");
		String recordedLicense = ("images/" + sellcars.get(0).getLicense() +fileType);
		sellcars.get(0).setLicense(recordedLicense);
		
		System.out.println(sellcars.toString());
		
		 String list = Arrays.toString(sellcars.toArray()).replace("[", "").replace("]", "");
			
			try{
				final String path = "C:\\Users\\admin\\Desktop\\Stream\\";
				String fileName = path+"Car_List.txt";	
				FileWriter fstream = new FileWriter(fileName,true);
				try (BufferedWriter out = new BufferedWriter(fstream)) {
				    out.write(list.toString());
				    out.close();
				}
				
				}

				catch (IOException e){
				System.err.println("Error: " + e.getMessage());
				}
			
			session.setAttribute("sellcrs", sellcars);
			


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
