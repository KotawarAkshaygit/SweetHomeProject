package com.sweethome.validate;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

/**
 * Servlet implementation class ValidateLet
 */
public class ValidateLet extends HttpServlet {
       

    int lad;
    int jel;
    int gul;
    int basu;
	static  Logger logger=(Logger) LogManager.getLogger();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		String laddu=request.getParameter("laddu");
		String gulab=request.getParameter("gulab");
		String jelebi=request.getParameter("jelebi");
		String basundhi=request.getParameter("basundhi");

		 if(laddu.isEmpty())
		 lad=0;
	     else
	    	 lad=Integer.parseInt(laddu);
		 if(jelebi.isEmpty())
			  jel=0;
		     else
		    	 jel=Integer.parseInt(jelebi);
		 if(gulab.isEmpty())
			 gul =0;
		     else
		    gul=Integer.parseInt(gulab);
		 if(basundhi.isEmpty())
			  basu=0;
		     else
		    	 basu=Integer.parseInt(basundhi);;
		 
		HttpSession session=request.getSession();
		session.setAttribute("laddu", lad);
		session.setAttribute("gulab", gul);
		session.setAttribute("jelebi",jel);
		session.setAttribute("basundhi", basu);
		PrintWriter out=response.getWriter();
		if(lad<0 && gul<0 && jel<0 && basu<0)
		{
			out.println("<center>Give The Valid Number<center>");
			logger.error("Invalid Details");
			RequestDispatcher rds=request.getRequestDispatcher("index.jsp");
			rds.include(request, response);
			
			
		}
		else
		{
			
			
			logger.info("redirecting to userdetails jsp");
			RequestDispatcher rd=request.getRequestDispatcher("userDetails.jsp");
			rd.forward(request, response);
		}
	
	}

}
