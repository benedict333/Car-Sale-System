package com.controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

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
 * Servlet implementation class AvailableCarsServlet
 */
@WebServlet("/AvailableCarsServlet")
public class AvailableCarsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AvailableCarsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
HttpSession session = request.getSession(true);
		
		
		ArrayList<Car> existingCarList = (ArrayList<Car>)session.getAttribute("existingCarList") ;
		
		List<Car> soldRecord= new ArrayList<Car>();
		
		Car option1 = new Car();
		
		 option1.setReport(request.getParameter("id"));
		 
		 System.out.println(option1.getReport());	
		 
				
			session.setAttribute("existingCarList", existingCarList);			

			System.out.println(existingCarList);
			
			for(int i =0; i>existingCarList.size(); i++)
			{
			System.out.println(existingCarList.get(i).getBoughtDate());
			}
		
		RequestDispatcher rs= request.getRequestDispatcher("AvailableCarsReport.jsp");
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
