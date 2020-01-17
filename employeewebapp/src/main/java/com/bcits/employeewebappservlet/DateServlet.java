package com.bcits.employeewebappservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.IOP.ServiceContext;

public class DateServlet extends HttpServlet {
	public DateServlet() {
		System.out.println("constructor");
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println(" init method");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// java code to generate current system date and time(dynamic)
		Date date=new Date();
		
		ServletConfig config=getServletConfig();
		String myConfigparamval=config.getInitParameter("ServletName");
		
		ServletContext context= getServletContext();
		String mycontextparamval=context.getInitParameter("appName");
				
		

		//code to generate dynamic response
		resp.setContentType("text/html");
		resp.setHeader("refresh", "1");
		PrintWriter out =resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>Current System Date & Time is:- "+date+"</h1>");
		out.println("<h2>Servlet name is:- "+myConfigparamval+"</h2>");
		out.println("<h2>Servlet name is:- "+mycontextparamval+"</h2>");
		out.println("</body>");    
		out.println("</html>");  

	}//End of doGet()
	
	@Override
	public void destroy() {
		System.out.println("destroyed");
	}
}
