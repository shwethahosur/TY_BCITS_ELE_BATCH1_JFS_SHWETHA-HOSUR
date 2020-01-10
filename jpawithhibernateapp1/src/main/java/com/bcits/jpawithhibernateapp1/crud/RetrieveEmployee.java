package com.bcits.jpawithhibernateapp1.crud;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import javax.persistence.Persistence;

import com.bcits.jpawithhibernateapp1.bean.Test1;

public class RetrieveEmployee {
public static void main(String[] args) {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("test1");
	EntityManager manager=entityManagerFactory.createEntityManager();
//	Test1 test1=manager.find(Test1.class, 101);
	Test1 test1=manager.getReference(Test1.class, 29);
	System.out.println(test1.getEmpname());
//	 System.out.println("employeeid========>"+test1.getEmpid());
//	 System.out.println("employeename========>"+test1.getEmpname());
//	 System.out.println("employee========>"+test1.getEmpblood_group());
//	 System.out.println("employeedesignation========>"+test1.getEmpdesignation());
//	 System.out.println("employeemangerid"+test1.getEmpmanager_id());
//	 System.out.println("employeeofficial-mail-id========>"+test1.getEmpofficial_mail_id());
//	 System.out.println("employeephno========>"+test1.getEmpphno());
//	 System.out.println("employeesalary========>"+test1.getEmpsalary());
//	 System.out.println("employee date of joining========>"+test1.getEmpdate_of_joining());
//	 System.out.println("employee date of birth========>"+test1.getEmpdate_of_birth());
//	 
	 manager.close();
	 
}
}
