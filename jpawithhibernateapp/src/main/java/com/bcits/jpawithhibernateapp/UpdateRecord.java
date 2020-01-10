package com.bcits.jpawithhibernateapp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.transaction.Transaction;

import com.bcits.jpawithhibernateapp.bean.Test;

public class UpdateRecord {
	public static void main(String[] args) {
//	EntityManagerFactory factory=null;
	EntityManager manager=null;
	EntityTransaction transaction=null;
	 try {
		 EntityManagerFactory factory=Persistence.createEntityManagerFactory("test");
		 manager=factory.createEntityManager();
		 transaction=manager.getTransaction();
		transaction.begin();
		Test test=manager.find(Test.class, 1);
		test.setMovieName("hum aapke hai koun");
		transaction.commit();
		System.out.println("record updated");
	} catch (Exception e) {
		
		e.printStackTrace();
		transaction.rollback();
	}finally {
		manager.close();
	
}
}
}
