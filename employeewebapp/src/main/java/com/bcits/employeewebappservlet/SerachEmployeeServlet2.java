package com.bcits.employeewebappservlet;


import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bcits.bean.Test1;
@WebServlet("/findEmployee")
public class SerachEmployeeServlet2  extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException{
	String empidval=req.getParameter("empid");
			int empid=Integer.parseInt(empidval);
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("test1");
	EntityManager manager=emf.createEntityManager();
	Test1 test1=manager.find(Test1.class, empid);
	resp.setContentType("text/html");
	PrintWriter out=resp.getWriter();
	if(test1!=null) {
		out.println("<html>");
		out.println("<body>");
		out.println("<h1 style='color:green'>Employee ID"+empid+"found</h1>");
		out.println("Name ="+test1.getEmpname());
		out.println("Name ="+test1.getEmpdeptid());
		out.println("Name ="+test1.getEmpphno());
		
		out.println("</body>");
		out.println("</html>");
	}else {
		out.println("<html>");
		out.println("<body>");
		
		out.println("<h1 style='color:red'>Employee ID"+empid+"not found</h1>");
		out.println("</body>");
		out.println("</html>");
			
	}
	manager.close();
	emf.close();
}
}
