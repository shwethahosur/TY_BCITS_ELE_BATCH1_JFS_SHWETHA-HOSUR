package com.bcits.jpawithhibernateapp1.crud;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.bcits.jpawithhibernateapp1.bean.Test1;

public class Reattached {
	public static void main(String[] args) {
		EntityManager manager = null;
		EntityTransaction transaction = null;
		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("test1");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			Test1 test1 = manager.find(Test1.class, 13);
			System.out.println(manager.contains(test1));
			System.out.println("executed");

			test1.setEmpsalary(5000);

			manager.detach(test1);
			System.out.println("detached");
			Test1 reattached = manager.merge(test1);
			reattached.setEmpdesignation("developer");
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			manager.close();
		}
	}
}
