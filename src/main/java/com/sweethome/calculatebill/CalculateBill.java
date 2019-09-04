package com.sweethome.calculatebill;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * Servlet implementation class CalculateBill
 */
public class CalculateBill extends HttpServlet {
	
	static Logger logger=LogManager.getLogger();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String customerName=request.getParameter("cname");
		String contact=request.getParameter("contact");
		
		HttpSession session=request.getSession();
		session.setAttribute("customerName", customerName);
		session.setAttribute("contact", contact);
		int lad=(Integer)session.getAttribute("laddu");
		int gul=(Integer)session.getAttribute("gulab");
		int jel=(Integer)session.getAttribute("jelebi");
		int basu=(Integer)session.getAttribute("basundhi");
		int result=0;
		int result1=0;
		int finals=0;
		
		
		
		
		int lres=lad*400;
		int gres=gul*500;
		int jres=jel*300;
		int bres=basu*600;
		
		/*switch(option)
		{
		case 1:
		{
			result=400*kgs;
			logger.info(result);
			break;
		}
		case 2:
		{
			result=500*kgs;
			logger.info(result);
			break;
		}
		case 3:
		{
			result=300*kgs;
			logger.info(result);
			break;
		}
		case 4:
		{
			result=400*kgs;
			logger.info(result);
				break;
		}
	
		
		default:
			System.out.println("Not Generated Bill");
			
		}

		switch(option1)
		{
		case 1:
		{
			result1=400*kgs1;
			logger.info(result1);
			break;
		}
		case 2:
		{
			result1=500*kgs1;
			logger.info(result1);
			break;
		}
		case 3:
		{
			result1=300*kgs;
			logger.info(result1);
			break;
		}
		case 4:
		{
			result1=400*kgs1;
			logger.info(result1);
				break;
		}
	
		
		default:
			System.out.println("Not Generated Bill");
			
		}
		*/
		
		finals=(lres+gres+jres+bres);
		int finalskg=(lad+gul+jel+basu);
		session.setAttribute("result", finals);
		session.setAttribute("finalskg", finalskg);
		response.sendRedirect("InsertToDB");
	}

}
