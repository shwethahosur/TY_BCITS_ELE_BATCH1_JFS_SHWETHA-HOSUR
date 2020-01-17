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
import javax.servlet.http.HttpSession;

import com.bcits.bean.Test1;
@WebServlet("/getEmployee")
public class GetEmployeeServlet  extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException{
	//validate the session
	HttpSession session=req.getSession(false);	
		resp.setContentType("text/html");
		PrintWriter out= resp.getWriter();
		if(session!=null) {
			//valid session
			//get the form data
		
		
		
		
		String empidval=req.getParameter("empid");
				int empid=Integer.parseInt(empidval);
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("test1");
		EntityManager manager=emf.createEntityManager();
		Test1 test1=manager.find(Test1.class, empid);
		//generate dynamic response
		if(test1!=null) {
		// display employee record
			Test1 loggedInEmpInfo=(Test1)session.getAttribute("test1");
			
			
			out.println("<html>");
			out.println("<body>");
			out.println("<h1>Hello"+loggedInEmpInfo.getEmpname()+"!</h1>");
			out.println("<h1 style='color:green'>Employee ID"+empid+"found</h1>");
			out.println("Name ="+test1.getEmpname());
			out.println("Name ="+test1.getEmpdeptid());
			out.println("Name ="+test1.getEmpphno());
			
			out.println("</body>");
			out.println("</html>");
		}
		manager.close();
		emf.close();
		}else {
			out.println("<html>");
			out.println("<body>");
			
			out.println("<h1 style='color:red'>please login first</h1>");
			out.println("</body>");
			out.println("</html>");
			
			req.getRequestDispatcher("./LoginForm.html").include(req, resp);
				
		}
		
	}	
	
	
	
	}
