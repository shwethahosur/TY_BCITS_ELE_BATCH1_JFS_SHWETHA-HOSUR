package com.bcits.jpawithhibernateapp1.crud;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.bcits.jpawithhibernateapp1.bean.Test1;

public class UpdateEmployee {

	public static void main(String[] args) {
		EntityTransaction transaction = null;
		EntityManager manager = null;
		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test1");
			manager = entityManagerFactory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			Test1 test1 = manager.find(Test1.class, 4);
			test1.setEmpsalary(85000);
			transaction.commit();
			System.out.println("record updated");
		} catch (Exception e) {

			e.printStackTrace();
			transaction.rollback();
		} finally {
			manager.close();

		}
	}
}
