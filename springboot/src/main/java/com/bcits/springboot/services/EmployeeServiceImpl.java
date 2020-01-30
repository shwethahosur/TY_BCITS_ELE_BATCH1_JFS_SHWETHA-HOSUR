package com.bcits.springboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcits.springboot.beans.EmployeeInfoBean;
import com.bcits.springboot.customexception.EmployeeException;
import com.bcits.springboot.dao.EmployeeDAO;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO dao;

	@Override
	public EmployeeInfoBean authenticate(int empId, String password) {
		return dao.authenticate(empId, password);
	}

	@Override
	public boolean addEmployee(EmployeeInfoBean employeeInfoBean) {
		return dao.addEmployee(employeeInfoBean);
	}

	@Override
	public boolean deleteEmployee(int empId) {
		if (empId < 1) {

			return false;
		}
		return dao.deleteEmployee(empId);
	}

	@Override
	public boolean updateEmployee(EmployeeInfoBean employeeInfoBean) {
		return dao.updateEmployee(employeeInfoBean);
	}

	@Override
	public EmployeeInfoBean getEmployee(int empId) {
		if (empId < 1) {
			throw new EmployeeException("exception occured");
		}
		EmployeeInfoBean employeeInfoBean = dao.getEmployee(empId);

		return employeeInfoBean;
	}// End of getEmployee()

	@Override
	public List<EmployeeInfoBean> getallEmployees() {
		// TODO Auto-generated method stub
		return dao.getAllEmployees();
	}

}
