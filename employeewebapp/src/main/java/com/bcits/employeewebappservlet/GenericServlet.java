package com.bcits.employeewebappservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/GenericServlet")
public class GenericServlet extends javax.servlet.GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String eNameval=req.getParameter("ename");                                        
		PrintWriter out =res.getWriter();
		out.println("<html>");
		out.println("<body>");	
		out.println("<h1 style='color':blue>welcome to generic servlet</h1>");
		out.println("<h2>employee name="+eNameval+"</h1>");
		out.println("</body>");	
		out.println("</html>");
	}

}
