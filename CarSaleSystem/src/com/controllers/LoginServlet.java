package com.controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
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
import com.car.User;
import com.car.loginUser;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		
		ArrayList<loginUser> userList = (ArrayList<loginUser>)session.getAttribute("userList") ;

		if (userList ==null)
		{
			userList = new ArrayList<loginUser>();
			final String path = "C:\\Users\\admin\\Desktop\\Stream\\";
			String fileName = path+"User_List.txt";		

			try {
				Scanner scanner = new Scanner(new File(fileName));
				StringBuilder importUserList = new StringBuilder();

				while(scanner.hasNext()) {

					importUserList.append(scanner.nextLine());						

					//convert the string into an arraylist

					String str=importUserList.toString();
					ArrayList<String> importedUserList= new ArrayList<String>(Arrays.asList(str.split("%")));
					
					
					for(int i=0; i<importedUserList.size(); i++)
					{
						//Car listUser = new Car ();
						loginUser list1 = new loginUser ();
						
						String lines = importedUserList.get(i);
						String [] parseLines = lines.split("_");
						list1.setUserName(parseLines[0]);						
						list1.setPassword(parseLines[1]);		
						list1.setUserEmail(parseLines[2]);								

						userList.add(list1); 
						
					}
				}
			}catch(FileNotFoundException e) {
				System.out.println("Error reading file: "+fileName);

			}

		}
	
		String name = request.getParameter("loginName");
		String pass = request.getParameter("loginPassword");
		
		ArrayList<loginUser> newUserList = new ArrayList<loginUser>();
		
		for (int j = 0; j < userList.size(); j++)				
			
		{	
			System.out.println(userList.get(j).getUserName());
			
			if (userList.get(j).getUserName().trim().equals(name) && userList.get(j).getPassword().trim().equals(pass))
			{

				newUserList.add(userList.get(j));
				
				break;	
				}
			
		}
		
		if (newUserList != null) {
		session.setAttribute("newUserList", newUserList);	
		
		RequestDispatcher rs= request.getRequestDispatcher("Home.jsp");
		rs.forward(request, response);	
			}
		else 
		{
			request.setAttribute("message", "Invalid Username or Password");
			
			RequestDispatcher rs= request.getRequestDispatcher("Login.jsp");
			rs.forward(request, response);	
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
