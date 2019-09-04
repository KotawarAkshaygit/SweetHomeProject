package com.sweethome.retrive;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.seethome.db.DBconnection;

/**
 * Servlet implementation class RetriveDB
 */
public class RetriveDB extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

	String pdate=request.getParameter("pdate");
	System.out.println(pdate);
	int sum=0;
		try
		{
		Connection con=DBconnection.getConnection();
		System.out.println(con);
		String query="select sum(amount) from sweethome where date_added=?";
		PreparedStatement st=con.prepareStatement(query);
		st.setString(1, pdate);
		ResultSet rs=st.executeQuery();
		 sum=0;
		while(rs.next())
		{
			 sum=rs.getInt(1);
			System.out.println(sum);
		}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		request.setAttribute("resultset", sum);
		request.setAttribute("pdate1", pdate);
		RequestDispatcher rd=request.getRequestDispatcher("successRetrive.jsp");
		rd.forward(request, response);
	}

}
