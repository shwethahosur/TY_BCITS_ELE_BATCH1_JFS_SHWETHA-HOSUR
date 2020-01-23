package com.bcits.springcoreannotations;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bcits.springannotation.beans.EmployeeBean;
import com.bcits.springannotation.config.EmployeeConfig2;

public class EmployeeTest2 {
public static void main(String[] args) {
	ApplicationContext context=new AnnotationConfigApplicationContext(EmployeeConfig2.class);
	EmployeeBean employeeBean=context.getBean(EmployeeBean.class);
	
	System.out.println("employee name:"+employeeBean.getName());
	System.out.println("employee age:"+employeeBean.getAge());
	System.out.println("department id:"+employeeBean.getDepartmentBean().getDeptId());
	System.out.println("department name:"+employeeBean.getDepartmentBean().getDeptName());
	
	
}
}
