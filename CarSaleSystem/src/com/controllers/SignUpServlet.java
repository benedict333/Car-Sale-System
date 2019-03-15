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
import com.car.User;
import com.car.loginUser;

/**
 * Servlet implementation class SignUpServlet
 */
@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Car> userList =new ArrayList<Car>();
		
		Car newUser = new Car();
		loginUser  newUser1 = new loginUser ();

					
		newUser1.setUserName(request.getParameter("userName"));
		newUser1.setPassword(request.getParameter("password"));
		newUser1.setUserEmail(request.getParameter("userEmail"));
		newUser.setLoginUser(newUser1);
		userList.add(newUser);
		
		
		HttpSession session = request.getSession(true);
		session.setAttribute("newUser", newUser);
		RequestDispatcher rs= request.getRequestDispatcher("Login.jsp");
		rs.forward(request, response);
		// String list = Arrays.toString(userList.toArray()).replace("[", "").replace("]", "");
			
			try{
				final String path = "C:\\Users\\admin\\Desktop\\Stream\\";
				String fileName = path+"User_List.txt";	
				FileWriter fstream = new FileWriter(fileName,true);
				try (BufferedWriter out = new BufferedWriter(fstream)) {
				    out.write(newUser1.print2());
				    out.close();
				}
				
				}

				catch (IOException e){
				System.err.println("Error: " + e.getMessage());
				}
			
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}