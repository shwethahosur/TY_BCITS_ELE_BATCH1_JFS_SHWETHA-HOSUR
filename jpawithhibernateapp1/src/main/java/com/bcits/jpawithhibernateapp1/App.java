package com.bcits.jpawithhibernateapp1;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


import com.bcits.jpawithhibernateapp1.bean.Test1;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	 
    	     Test1 test=new Test1();
    	     test.setEmpid(16);
    	     test.setEmpname("shreya");
    	     test.setEmpphno(964525361);
    	     test.setEmpofficial_mail_id("shreya123@gmail.com");
    	     test.setEmpdate_of_birth(java.sql.Date.valueOf("1995-05-20"));
    	     test.setEmpdate_of_joining(java.sql.Date.valueOf("2019-05-20"));
    	     test.setEmpdesignation("manager");
    	     test.setEmpblood_group("b+ve");
    	     test.setEmpsalary(2000);
    	     test.setEmpdeptid(35);
    	     test.setEmpmanager_id(21);
    	     
    	     
    	     EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("test1");
    	     EntityManager manager=entityManagerFactory.createEntityManager();
    	     EntityTransaction transaction=manager.getTransaction();
    	     transaction.begin();
    	     manager.persist(test);
    	     System.out.println("record saved");
    	     transaction.commit();
    	     manager.close();
    	    }
    }

