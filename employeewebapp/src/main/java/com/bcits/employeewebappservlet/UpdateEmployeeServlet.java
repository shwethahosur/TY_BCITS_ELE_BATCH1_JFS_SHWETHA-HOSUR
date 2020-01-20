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

@WebServlet("/updateEmployee")
public class UpdateEmployeeServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession(false);	
		resp.setContentType("text/html");
		PrintWriter out= resp.getWriter();
		if(session!=null) {
			//valid session
			//get the form data
		
		
		
		String empIdVal = req.getParameter("empid");
		int empid = Integer.parseInt(empIdVal);
		String empname=req.getParameter("empname");
		

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test1");
		EntityManager manager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		Test1 test1 = manager.find(Test1.class, empid);

		resp.setContentType("text/html");

		

		if (test1== null) {
			out.println("<html>");
			out.println("<body>");
			out.println("<h1 style='color:red'>Employee details for empId " + empid + " not found <h1>");
			out.println("</body>");
			out.println("</html>");
		} else {
			test1.setEmpname(empname);
////			test1.setEmpdesignation("developer");
//			test1.setEmpname("usha");
//			test1.setEmpblood_group("b+ve");
			transaction.commit();

			out.println("<html>");
			out.println("<body>");
			out.println("<h1 style='color:green'>Employee record for " + empid + " is updated <h1>");
			out.println("</body>");
			out.println("</html>");
		}
		manager.close();
		entityManagerFactory.close();

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
