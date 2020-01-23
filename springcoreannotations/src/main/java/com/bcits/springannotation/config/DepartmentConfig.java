package com.bcits.springannotation.config;

import org.springframework.context.annotation.Bean;

import com.bcits.springannotation.beans.DepartmentBean;

public class DepartmentConfig {

	 @Bean(name="dev")
	  public DepartmentBean getDepartmentBean() {
		  DepartmentBean departmentBean=new DepartmentBean();
		  departmentBean.setDeptId(101);
		  departmentBean.setDeptName("dev");
		  return departmentBean;
	  }
	//  @Primary 
	  @Bean(name="hr")
	  public DepartmentBean getDeptHR() {
		  DepartmentBean departmentBean=new DepartmentBean();
		  departmentBean.setDeptId(102);
		  departmentBean.setDeptName("HR");
		  return departmentBean;
	  }
	  
	  @Bean(name="acc")
	  public DepartmentBean getDeptAccount() {
		  DepartmentBean departmentBean=new DepartmentBean();
		  departmentBean.setDeptId(103);
		  departmentBean.setDeptName("Account");
		  return departmentBean;
	  }
	
}
