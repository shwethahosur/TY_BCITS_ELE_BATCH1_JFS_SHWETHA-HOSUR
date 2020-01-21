package com.bcits.hugecase1.consumer_db;

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


import com.bcits.hugecase1.consumer.bean.ConsumerSignUp;
@WebServlet("/consumersignup")
public class ConsumerSignUpTest extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String meterno = req.getParameter("Meternumber");
		String fnameval = req.getParameter("consumerFirstname");
	    String lnameval = req.getParameter("consumerLastname");
	    String mobilenumber = req.getParameter("consumerphno");
		String mail_id = req.getParameter("consumer_mail_id");
		String password = req.getParameter("password");
		String Region = req.getParameter("Region");
        String type_of_consumer=req.getParameter("Type_of_consumer");
		
		
		ConsumerSignUp signUp=new ConsumerSignUp();
      	signUp.setMeternumber(Integer.parseInt(meterno ));
     	signUp.setConsumerphno(Long.parseLong(mobilenumber));
		signUp.setConsumerFirstname(fnameval);
        signUp.setConsumerLastname(lnameval);
		
		signUp.setConsumer_mail_id(mail_id);
		signUp.setPassword(password);
		signUp.setRegion(Region);
		signUp.setType_of_consumer(type_of_consumer);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("consumersignup");
		EntityManager manager = emf.createEntityManager();
		EntityTransaction tx = manager.getTransaction();
		boolean isadded = false;
		try {
			tx.begin();
			manager.persist(signUp);
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
			out.println("<h1 style='color:green'> for" + meterno + " consumer details added <h1>");
		} else {
			out.println("<h1 style='color:red'>Employee ID " + meterno + " not Found <h1>");
		}
		out.println("</body>");
		out.println("</html>");

	}
		
}