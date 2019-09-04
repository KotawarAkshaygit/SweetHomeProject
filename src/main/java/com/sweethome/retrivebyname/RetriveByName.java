package com.sweethome.retrivebyname;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.seethome.db.DBconnection;

/**
 * Servlet implementation class RetriveByName
 */
public class RetriveByName extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name=request.getParameter("rname");
		int sum=0;
		try
		{
		Connection con=DBconnection.getConnection();
		System.out.println(con);
		String query="select sum(amount) from sweethome where customerName=?";
		PreparedStatement st=con.prepareStatement(query);
		st.setString(1, name);
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
		
		request.setAttribute("cname", name);
		RequestDispatcher rd=request.getRequestDispatcher("successretrivename.jsp?amount="+sum);
		rd.forward(request, response);
	}

}
