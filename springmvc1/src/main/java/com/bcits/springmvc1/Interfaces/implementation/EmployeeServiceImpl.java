package com.bcits.springmvc1.Interfaces.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.bcits.springmvc1.bean.EmployeeInfoBean;
import com.bcits.springmvc1.customexceptions.EmployeeException;
import com.bcits.springmvc1.services.EmployeeService;
@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	
	@Autowired
	private EmployeeDAO dao;
	
	@Override
	public EmployeeInfoBean authenticate(int empid, String password) {
		// TODO Auto-generated method stub
		return  dao.authenticate(empid, password);
	}

	@Override
	public boolean addEmployee(EmployeeInfoBean employeeInfoBean) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteEmployee(int empid) {
		if(empid<1) {
			return false;
		}
		return dao.deleteEmployee(empid);
	}

	@Override
	public boolean updateEmployee(EmployeeInfoBean employeeInfoBean) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public EmployeeInfoBean getEmployee(int empid) {
		if(empid<1) {
			throw new EmployeeException("invalid employee id");
//			return null;
		}
		EmployeeInfoBean employeeInfoBean=dao.getEmployee(empid);
		if(employeeInfoBean!=null) {
			throw new EmployeeException("employee Id not found");
		}
//		return dao.getEmployee(empid);
		return employeeInfoBean;
	}// End of getEmployee()

	@Override
	public List<EmployeeInfoBean> getallEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

}
