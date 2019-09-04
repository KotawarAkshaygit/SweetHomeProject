package com.sweethome.insertDB;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.seethome.db.DBconnection;


/**
 * Servlet implementation class InsertToDB
 */

public class InsertToDB extends HttpServlet {

	static Logger logger=LogManager.getLogger();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
		if(session.getAttribute("customerName")==null)
			response.sendRedirect("home.jsp");
		
		String customerName=(String)session.getAttribute("customerName");
		String contact=(String) session.getAttribute("contact");
		PrintWriter out=response.getWriter();
		int amount=(Integer)session.getAttribute("result");
		int finalskg=(Integer)session.getAttribute("finalskg");
		
		
		


	/*	ServletContext ctx=request.getServletContext();
		String url=ctx.getInitParameter("URL");
		logger.info(url);
		ServletContext ctx1=request.getServletContext();
		String password=ctx1.getInitParameter("password");
		
		ServletContext ctx2=request.getServletContext();
		String username=ctx2.getInitParameter("username");
		
		ServletContext ctx3=request.getServletContext();
		String driver=ctx3.getInitParameter("driver"); */
	//	int amount=(Integer)session.getAttribute("result");
		try
		{
		
		/*Class.forName(driver);
		logger.info("Successfully loaded driver");
		
		Connection con=DriverManager.getConnection(url,username,password);
		logger.info("Successfully Connected to DB"); */
		Connection con=DBconnection.getConnection();
		System.out.println(con);
		PreparedStatement pt=con.prepareStatement("insert into sweethome(customerName,contact,amount,date_added)values(?,?,?,now())");
		pt.setString(1,customerName);
		pt.setString(2, contact);
		pt.setInt(3, amount);
		logger.info("connected to prepared statement");
		int s= pt.executeUpdate();
		
		if(s>0)
		{
			logger.info("redirecting to success jsp");
			RequestDispatcher rd=request.getRequestDispatcher("Success.jsp");
			rd.forward(request, response);
		}
		
		System.out.println(finalskg);
		System.out.println(amount);
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
