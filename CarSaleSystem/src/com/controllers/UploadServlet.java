package com.controllers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

@WebServlet("/UploadServlet")
@MultipartConfig(fileSizeThreshold=1024*1024*2,	// 2MB
				 maxFileSize=1024*1024*100,		// 100MB
				 maxRequestSize=1024*1024*100)	// 100MB

public class UploadServlet extends HttpServlet {

	/**
	 * Name of the directory where uploaded files will be saved, relative to
	 * the web application directory.
	 */
	private static final String SAVE_DIR = "uploadFiles";

	/**
	 * handles file upload
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// gets absolute path of the web application
		//String appPath = request.getServletContext().getRealPath("");
		// constructs path of the directory to save uploaded file
		String savePath = "D:\\Beno-Claim-Java\\The-Latest_Workspace\\CarSaleSystem\\WebContent\\images";

		// creates the save directory if it does not exists
		File fileSaveDir = new File(savePath);
		if (!fileSaveDir.exists()) {
			fileSaveDir.mkdir();
		}
HttpSession session = request.getSession(true);
		
			
		for (Part part : request.getParts()) {
			
			
			// refines the fileName in case it is an absolute path
			String fileName = extractFileName(part);
			fileName = new File(fileName).getName();
			//String name = part.getContentType();
			//System.out.println(name);
			int lastIndexOf = fileName.lastIndexOf(".");			 
			 
			String type= fileName.substring(lastIndexOf);
			
			String finalFileName = (String)session.getAttribute("carLicense");	//extractFileName(part);
			part.write(savePath + File.separator + finalFileName + type);
			session.setAttribute("filetype", type);
		}

		request.setAttribute("message", "Please click below to confirm Your request");
		getServletContext().getRequestDispatcher("/message.jsp").forward(
				request, response);
		
		
	}

	
	
	/**
	 * Extracts file name from HTTP header content-disposition
	 */
	private String extractFileName(Part part) {
		String contentDisp = part.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		for (String s : items) {
			if (s.trim().startsWith("filename")) {
				return s.substring(s.indexOf("=") + 2, s.length()-1);
			}
		}
		return "";
	}
}