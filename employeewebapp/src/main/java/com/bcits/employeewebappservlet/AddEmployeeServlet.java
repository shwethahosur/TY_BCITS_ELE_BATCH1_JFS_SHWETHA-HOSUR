package com.bcits.employeewebappservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bcits.bean.Test1;

@WebServlet("/addEmployee")
public class AddEmployeeServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String empidval = req.getParameter("empid");
		String nameval = req.getParameter("empname");
		String designationval = req.getParameter("designation");
		String mobilenumber = req.getParameter("empphno");
		String joiningdateval = req.getParameter("empdate_of_joining");

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date joiningdate = null;
		try {
	
			joiningdate=dateFormat.parse(joiningdateval);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}

		Test1 test1 = new Test1();
		test1.setEmpid(Integer.parseInt(empidval));
		test1.setEmpname(nameval);
		test1.setEmpdesignation(designationval);
		test1.setEmpphno(Long.parseLong(mobilenumber));
		test1.setEmpdate_of_joining(joiningdate);

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("test1");
		EntityManager manager = emf.createEntityManager();
		EntityTransaction tx = manager.getTransaction();
		boolean isadded = false;
		try {
			tx.begin();
			manager.persist(test1);
			tx.commit();
			isadded = true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		manager.close();
		emf.close();

		PrintWriter out = resp.getWriter();

		out.println("<html>");
		out.println("<body>");
		if (isadded) {
			out.println("<h1 style='color:green'>Employee ID " + empidval + " Found <h1>");
		} else {
			out.println("<h1 style='color:red'>Employee ID " + empidval + " not Found <h1>");
		}
		out.println("</body>");
		out.println("</html>");

	}
}
