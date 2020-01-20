package com.bcits.jsp.getallemp;

import java.io.IOException;
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

import com.bcits.bean.Test1;
@WebServlet("/seeAllEmployees")
public class GetAllEmployeeServlet  extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("test1");
		EntityManager manager = factory.createEntityManager();
		
		String jpql = "from Test1";

		Query query = manager.createQuery(jpql);
		List<Test1> list = query.getResultList();
		req.setAttribute("employeeList", list);
		manager.close();
		factory.close();
		req.getRequestDispatcher("/seeAllEmp.jsp").forward(req, resp);
		}

}
