package com.bcits.employeewebappservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/getcookie")
public class GetCookie extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	Cookie cookies[]=req.getCookies();
	PrintWriter out=resp.getWriter();
	out.println("<html>");
	out.println("<body>");
	for(Cookie cookie:cookies) {
		out.println("<h2> cookie name="+ cookie.getName());
		out.println("<br> cookie value="+ cookie.getValue());
		
	}
	
	
	out.println("</body>");
	out.println("</html>");
}
}
