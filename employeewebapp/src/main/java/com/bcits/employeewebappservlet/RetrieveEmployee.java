package com.bcits.employeewebappservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
@WebServlet("/retrieveEmployee")
public class RetrieveEmployee extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession(false);	
		resp.setContentType("text/html");
		PrintWriter out= resp.getWriter();
		if(session!=null) {
			//valid session
			//get the form data
		
		
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("test1");
		EntityManager manager = factory.createEntityManager();
		
		String jpql = "from Test1";

		Query query = manager.createQuery(jpql);
		List<Test1> list = query.getResultList();
//		PrintWriter out = resp.getWriter();
		for (Test1 test1 : list) {

			out.println("employee_Id......." + test1.getEmpid());
			out.println("employee_Name....." + test1.getEmpname());
			out.println("employee_MobileNo." + test1.getEmpphno());
			out.println("official_mailid   " + test1.getEmpofficial_mail_id());
			out.println("date of birth ==  " + test1.getEmpdate_of_birth());
			out.println("date of joing ==  " + test1.getEmpdate_of_joining());
			out.println("designation ==    " + test1.getEmpdesignation());
			out.println("blood_group==     " + test1.getEmpblood_group());
			out.println("salary==          " + test1.getEmpsalary());
			out.println("dept_id==         " + test1.getEmpdeptid());
			out.println("manger_id==       " + test1.getEmpmanager_id());
			out.println("=================================================");
		}

		manager.close();
		factory.close();

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