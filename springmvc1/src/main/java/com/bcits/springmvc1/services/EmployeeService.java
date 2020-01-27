package com.bcits.springmvc1.services;

import java.util.List;

import com.bcits.springmvc1.bean.EmployeeInfoBean;

public interface EmployeeService {
	public EmployeeInfoBean authenticate(int empid,String password);
	
	public boolean addEmployee(EmployeeInfoBean employeeInfoBean);
	public boolean deleteEmployee(int empid);
	public boolean updateEmployee(EmployeeInfoBean employeeInfoBean);
	public EmployeeInfoBean getEmployee (int empid);
	public List<EmployeeInfoBean> getallEmployees();
}//end of service
