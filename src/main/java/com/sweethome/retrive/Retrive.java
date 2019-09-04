package com.sweethome.retrive;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Retrive
 */
public class Retrive extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		int opt1=Integer.parseInt(request.getParameter("opt1"));
		
		switch(opt1)
		{
		case 1:
			RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
			break;
			
		case 2:
			RequestDispatcher rd1=request.getRequestDispatcher("retrives.jsp");
			rd1.forward(request, response);
			break;
		case 3:
			RequestDispatcher rd2=request.getRequestDispatcher("retrivebyname.jsp");
			rd2.forward(request,response);
			break;

			
		}
		
		
	}

}
