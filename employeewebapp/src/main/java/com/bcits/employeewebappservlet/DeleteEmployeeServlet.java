package com.bcits.employeewebappservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bcits.bean.Test1;

@WebServlet("/deleteEmployee")
public class DeleteEmployeeServlet extends HttpServlet  {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		
		HttpSession session=req.getSession(false);	
		resp.setContentType("text/html");
		PrintWriter out= resp.getWriter();
		if(session!=null) {
			//valid session
			//get the form data
			session.invalidate();
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("test1");
		EntityManager manager = emf.createEntityManager();
		
		
		
		//Get the form data
		String empIdVal = req.getParameter("empid");
		int empid = Integer.parseInt(empIdVal);
		
		
		EntityTransaction transaction=manager.getTransaction();
		transaction.begin();
		
		Test1 test1=manager.find(Test1.class, empid);
		manager.remove(test1);
		transaction.commit();
		
		
			//display empId not found
			out.println("<html>");
			out.println("<body>");
			out.println("<h1 style='color:red'>Employee ID "+ empid +" Found <h1>");
			out.println("</body>");
			out.println("</html>");
	
		
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
		
		
		
	}// End of doGet
}
