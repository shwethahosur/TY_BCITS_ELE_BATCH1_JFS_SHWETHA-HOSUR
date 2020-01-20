package com.bcits.jspservlet;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bcits.bean.Test1;
@WebServlet("/login2")
public class LoginServlet extends HttpServlet {
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
		test1 = (Test1)query.getSingleResult();
	}catch(Exception e) {
		e.printStackTrace();
	}
	if( test1!=null) {
		//valid credential
		HttpSession session= req.getSession(true);
		session.setAttribute("loggedInEmpInfo", test1);
		req.getRequestDispatcher("./home.jsp").forward(req, resp);
		
	}else {
		// invalid credentials
		req.setAttribute("msg", "Invalid EmployeeID/password");
		req.getRequestDispatcher("./login.jsp").forward(req, resp);
	}
}
}
