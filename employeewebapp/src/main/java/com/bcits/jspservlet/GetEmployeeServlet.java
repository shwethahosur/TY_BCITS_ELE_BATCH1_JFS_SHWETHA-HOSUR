package com.bcits.jspservlet;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bcits.bean.Test1;
@WebServlet("/getEmp")
public class GetEmployeeServlet extends HttpServlet{
 @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// get the form data
	 String empidval=req.getParameter("empid");
		int empid=Integer.parseInt(empidval);
		//search record in db
EntityManagerFactory emf=Persistence.createEntityManagerFactory("test1");
EntityManager manager=emf.createEntityManager();
Test1 test1=manager.find(Test1.class, empid);

req.setAttribute("empinfo", test1);
// send data to jsp
manager.close();
emf.close();

req.getRequestDispatcher("./searchEmployee.jsp").forward(req, resp);
}//end of do get()
}//end of class
