package com.bcits.springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bcits.springcore.beans.EmployeeBean;

public class EmployeeTest2 {
public static void main(String[] args) {
	ApplicationContext context=new ClassPathXmlApplicationContext("allimport.xml");
	EmployeeBean employeeBean=context.getBean("employee", EmployeeBean.class);
	System.out.println("emp name"+employeeBean.getName());
	System.out.println("emp age"+employeeBean.getAge());
	System.out.println("dept name"+employeeBean.getDepartmentBean().getDeptname());
	System.out.println("dept id"+employeeBean.getDepartmentBean().getDeptid());
}
}
