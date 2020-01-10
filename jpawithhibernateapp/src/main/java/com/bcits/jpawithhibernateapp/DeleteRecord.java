package com.bcits.jpawithhibernateapp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.bcits.jpawithhibernateapp.bean.Test;

public class DeleteRecord {
	public static void main(String[] args) {
		EntityTransaction transaction = null;
		EntityManager manager = null;
		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test");
			manager = entityManagerFactory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			Test test = manager.find(Test.class,2);
			manager.remove(test);
			transaction.commit();
			System.out.println("record deleted");
		} catch (Exception e) {                                                    
			e.printStackTrace();
			transaction.rollback();

		} finally {
			manager.close();
		}
	}
}
