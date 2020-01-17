package com.bcits.employeewebappservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bcits.bean.Test1;
@WebServlet("/Login")
public class LoginServlet  extends HttpServlet{
  @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// get all the parameters
	  
	int empIdVal=Integer.parseInt(req.getParameter("empid"))  ;
	String password= req.getParameter("password");	  
EntityManagerFactory factory=Persistence.createEntityManagerFactory("test1");
EntityManager manager=factory.createEntityManager();

 String jpql ="from Test1 where empid=:empid and password=:pwd";
Query query=manager.createQuery(jpql);
query.setParameter("empid", empIdVal);
query.setParameter("pwd", password);

Test1 test1=null;
try {
	test1=(Test1) query.getSingleResult();
	
}catch(Exception e) {
	e.printStackTrace();
}
resp.setContentType("text/html");
PrintWriter out=resp.getWriter();
out.println("<html>");
out.println("<body>");

if(test1!=null) {
	HttpSession session=req.getSession(true);
	
	
	session.setMaxInactiveInterval(60);
	session.setAttribute("test1", test1);
	
	out.println("<h1 style='color:green'>welcome"+test1.getEmpname());
	RequestDispatcher dispatcher=req.getRequestDispatcher("./LoginHome.html");
dispatcher.include(req, resp);
	
}else {
	out.println("<h1 style='color:red'>invalid credential</h1>");
	RequestDispatcher dispatcher=req.getRequestDispatcher("./LoginForm.html");
	dispatcher.include(req, resp);	
	
}
out.println("</body>");
out.println("</html>");
manager.close();
factory.close();

	 
}
}
