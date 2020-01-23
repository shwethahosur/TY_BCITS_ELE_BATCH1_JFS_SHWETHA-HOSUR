package com.bcits.springannotation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;

import com.bcits.springannotation.beans.DepartmentBean;
import com.bcits.springannotation.beans.EmployeeBean;
@Import(DepartmentConfig.class)
@Configuration
public class EmployeeConfig2 {
	@Bean
    public EmployeeBean getEmployeeBean() {
    	EmployeeBean employeeBean=new EmployeeBean();
    	employeeBean.setName("akshata");
    	employeeBean.setAge(21);
    	
//    	employeeBean.setDepartmentBean(getDepartmentBean());.....injecting department
    	return employeeBean;
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
    
//  @Bean(name="dev")
//  public DepartmentBean getDepartmentBean() {
//	  DepartmentBean departmentBean=new DepartmentBean();
//	  departmentBean.setDeptId(101);
//	  departmentBean.setDeptName("dev");
//	  return departmentBean;
//  }
////  @Primary 
//  @Bean(name="hr")
//  public DepartmentBean getDeptHR() {
//	  DepartmentBean departmentBean=new DepartmentBean();
//	  departmentBean.setDeptId(102);
//	  departmentBean.setDeptName("HR");
//	  return departmentBean;
//  }
//  
//  @Bean(name="acc")
//  public DepartmentBean getDeptAccount() {
//	  DepartmentBean departmentBean=new DepartmentBean();
//	  departmentBean.setDeptId(103);
//	  departmentBean.setDeptName("Account");
//	  return departmentBean;
//  }
  
    
}
