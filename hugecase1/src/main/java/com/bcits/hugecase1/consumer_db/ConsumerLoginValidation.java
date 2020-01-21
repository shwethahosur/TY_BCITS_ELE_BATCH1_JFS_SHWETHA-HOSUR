package com.bcits.hugecase1.consumer_db;

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

import com.bcits.hugecase1.consumer.bean.ConsumerSignUp;

@WebServlet("/getlogin")
public class ConsumerLoginValidation  extends HttpServlet{
	 @Override
	 protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 	// get all the parameters
	 	  
	 	int meterno=Integer.parseInt(req.getParameter("Meternumber"))  ;
	 	String password= req.getParameter("password");	  
	 EntityManagerFactory factory=Persistence.createEntityManagerFactory("consumersignup");
	 EntityManager manager=factory.createEntityManager();

	  String jpql ="from ConsumerSignUp where Meternumber=:Meternumber and password=:pwd";
	 Query query=manager.createQuery(jpql);
	 query.setParameter("Meternumber", meterno);
	 query.setParameter("pwd", password);

	 ConsumerSignUp signUp=null;
	 try {
		 signUp=(ConsumerSignUp) query.getSingleResult();
	 	
	 }catch(Exception e) {
	 	e.printStackTrace();
	 }
	
	 PrintWriter out=resp.getWriter();
	 out.println("<html>");
	 out.println("<body>");

	 if(signUp!=null) {
	 	HttpSession session=req.getSession(true);
	 	
	 	
	 	session.setMaxInactiveInterval(60);
	 	session.setAttribute("test1", signUp);
	 	
	 	out.println("<h1 style='color:green'>welcome"+signUp.getConsumerFirstname());
	 	RequestDispatcher dispatcher=req.getRequestDispatcher("./LoginHome.html");
	 dispatcher.include(req, resp);
	 	
	 }else {
	 	out.println("<h1 style='color:red'>invalid credential</h1>");
	 	RequestDispatcher dispatcher=req.getRequestDispatcher("./consumersignup.html");
	 	dispatcher.include(req, resp);	
	 	
	 }
	 out.println("</body>");
	 out.println("</html>");
	 manager.close();
	 factory.close();

	 	 
	 }
}
