package com.bcits.jpawithhibernateapp1.crud;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.bcits.jpawithhibernateapp1.bean.Test1;



public class FindEmployee {
public static void main(String[] args) {
	
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("test1");
    EntityManager manager=entityManagerFactory.createEntityManager();
	Test1 test1=manager.find(Test1.class, 3);	
	System.out.println("empid====>"+test1.getEmpid());
	System.out.println("empname====>"+test1.getEmpname());
	System.out.println("empphno====>"+test1.getEmpphno());
	System.out.println("Empdesignation====>"+test1.getEmpdesignation());
	System.out.println("Empofficial_mail_id====>"+test1.getEmpofficial_mail_id());
	System.out.println("Empsalary====>"+test1.getEmpsalary());
	System.out.println("Empmanager_id====>"+test1.getEmpmanager_id());
	System.out.println("Empdate_of_birth====>"+test1.getEmpdate_of_birth());
	System.out.println("Empblood_group====>"+test1.getEmpblood_group());
	
	
	
	
}
}
