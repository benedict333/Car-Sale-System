package com.controllers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

/**
 * Servlet implementation class BillingServlet
 */
@WebServlet("/BillingServlet")
public class BillingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BillingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		
		String id = (String)session.getAttribute("carLicenseId");		
			
		
		ArrayList<Car> existingCarList = (ArrayList<Car>)session.getAttribute("existingCarList") ;
		
		System.out.println(existingCarList.size());
		
		ArrayList<Car> soldcars =new ArrayList<Car>();
		
		Car soldcar= new Car();
		
		User soldCarUser = new User();
		
		
		soldCarUser.setFirstname(request.getParameter("firstname"));
		soldCarUser.setLastName(request.getParameter("lastname"));
		soldCarUser.setEmail(request.getParameter("email"));
		soldCarUser.setPhoneNumber(request.getParameter("phonenumber"));
		soldCarUser.setAddress(request.getParameter("address"));
		soldCarUser.setCreditcard(request.getParameter("creditcard"));
		
		String date1 =request.getParameter("solddate");
		 SimpleDateFormat formatter =new SimpleDateFormat("MM/dd/yyyy");  
		java.util.Date date2 = null;
		try {
			date2 = formatter.parse(date1);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		
		soldCarUser.setSoldDate((Date) date2);
		
		soldcar.setUser(soldCarUser);
		
				
		
		int arrayListId=0;
		
		for (int i=0; i<existingCarList.size(); i++)
		{
			if(existingCarList.get(i).toString().contains(id))
					{
				arrayListId=i;
				
				System.out.println(arrayListId);			
			
		soldcar.setCarType(existingCarList.get(i).getCarType());		
		soldcar.setLicense(existingCarList.get(i).getLicense());		
		soldcar.setMake(existingCarList.get(i).getMake());	
		soldcar.setBodyType(existingCarList.get(i).getBodyType());
		soldcar.setColor(existingCarList.get(i).getColor());
		soldcar.setYear(existingCarList.get(i).getYear());
		soldcar.setMiles(existingCarList.get(i).getMiles());
		soldcar.setOldPriceStr(existingCarList.get(i).getOldPriceStr());
		soldcar.setOldPriceStr(existingCarList.get(i).getOldPriceStr());		
		soldcar.setDiscountStr(existingCarList.get(i).getDiscountStr());
		soldcar.setNewPriceStr(existingCarList.get(i).getNewPriceStr());
		soldcar.setBoughtDate(existingCarList.get(i).getBoughtDate());	
		break;
			}
			
		}		
		soldcars.add(soldcar);	
		
						
		// String list = Arrays.toString(soldcars.toArray()).replace("[", "").replace("]", "");
		
		try{
			final String path = "C:\\Users\\admin\\Desktop\\Stream\\";
			String fileName = path+"Sold_Car_List.txt";	
			FileWriter fstream = new FileWriter(fileName,true);
			try (BufferedWriter out = new BufferedWriter(fstream)) {
				for (Car car : soldcars) {
					out.write(car.print1());
				}
			    out.close();
			}
			
			}

			catch (IOException e){
			System.err.println("Error: " + e.getMessage());
			}
		
		existingCarList.remove(arrayListId);
		
		final String path = "C:\\Users\\admin\\Desktop\\Stream\\";
		String fileName = path+"Car_List.txt";
		
		File f = new File(path+"Car_List.txt");
		if(f.exists() && !f.isDirectory()) { 
		    f.delete();
		}
				
		try{
				
			FileWriter fstream = new FileWriter(fileName,true);
			try (BufferedWriter out = new BufferedWriter(fstream)) {
				for (Car car : existingCarList) {
					out.write(car.toString());
				}
			    out.close();
			}
			
			}

			catch (IOException e){
			System.err.println("Error: " + e.getMessage());
			}
			
		
		
		session.setAttribute("existingCarList", existingCarList);	
		session.setAttribute("soldcars", soldcars);	
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
