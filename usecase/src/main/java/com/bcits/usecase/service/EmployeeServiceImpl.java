package com.bcits.usecase.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcits.usecase.beans.AdminInfoBean;
import com.bcits.usecase.beans.BillHistory;
import com.bcits.usecase.beans.CommentsInfo;
import com.bcits.usecase.beans.ConsumerCurrentBill;
import com.bcits.usecase.beans.ConsumerInfoBean;
import com.bcits.usecase.beans.EmployeeMaster;
import com.bcits.usecase.beans.MonthlyConsumption;
import com.bcits.usecase.dao.EmployeeDAO;


@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeDAO dao;

	
	@Override
	public List<ConsumerInfoBean> getAllConsumers() {
		return dao.getAllConsumers();
	}


	@Override
	public EmployeeMaster authenticate(Integer empId, String password) {
		// TODO Auto-generated method stub
		return dao.authenticate(empId, password);
	}


	@Override
	public List<ConsumerInfoBean> getRegionWiseConsumers( String region) {
		// TODO Auto-generated method stub
		return dao.getRegionWiseConsumers(region);
	}


	@Override
	public boolean generateBill(ConsumerCurrentBill consumerCurrentBill,String rrNo) {
		// TODO Auto-generated method stub
		return dao.generateBill(consumerCurrentBill,rrNo);
	}


	@Override
	public List<CommentsInfo> getComments(String region) {
		// TODO Auto-generated method stub
		return dao.Comments( region);
	}


	@Override
	public List<MonthlyConsumption> getMonthlyConsumption(String region) {
		// TODO Auto-generated method stub
		return dao.getMonthlyConsumption(region);
	}


	@Override
	public List<BillHistory> getMonthlyRevenue(String region) {
		// TODO Auto-generated method stub
		return dao.getMonthlyRevenue(region);
	}


	@Override
	public AdminInfoBean authenticate(int adminId, String password) {
		// TODO Auto-generated method stub
		return dao.authenticate(adminId, password);
	}


	@Override
	public boolean addEmployee(EmployeeMaster employeeMaster) {
		// TODO Auto-generated method stub
		return dao.addEmployee(employeeMaster);
	}


	

	
	
	
}
