package com.controllers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.car.Car;

/**
 * Servlet implementation class SellCarServlet
 */

@MultipartConfig
@WebServlet(urlPatterns = { "/SellCarServlet" })
public class SellCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SellCarServlet() {
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
		String imageName = request.getParameter("license");
		
		
		ArrayList<Car> sellcars = (ArrayList<Car>)session.getAttribute("sellcars");
		if (sellcars ==null)
		{
		sellcars =new ArrayList<Car>();
		}
		Car sellcar= new Car();
		sellcar.setCarType(request.getParameter("carType"));
		sellcar.setLicense(request.getParameter("license"));		
		sellcar.setMake(request.getParameter("make"));		
		sellcar.setBodyType(request.getParameter("bodyType"));
		sellcar.setColor(request.getParameter("color"));
		sellcar.setYear(request.getParameter("year"));
		sellcar.setMiles(request.getParameter("miles"));
		String price1=(request.getParameter("price"));
		sellcar.setOldPrice(Double.valueOf(price1));
		sellcar.setDiscount(0.0);
		sellcar.setNewPrice(0.0);
		sellcar.setBoughtDate(request.getParameter("boughtDate"));
		
		sellcars.add(sellcar);
		 
		
		
		
		session.setAttribute("sellcars", sellcars);	
		session.setAttribute("carLicense", imageName);
		 RequestDispatcher rs= request.getRequestDispatcher("upload.jsp");
			rs.forward(request, response);
	}

	
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doGet(request,response);
}
}
