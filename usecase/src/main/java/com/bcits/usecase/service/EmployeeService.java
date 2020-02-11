package com.bcits.usecase.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bcits.usecase.beans.AdminInfoBean;
import com.bcits.usecase.beans.BillHistory;
import com.bcits.usecase.beans.CommentsInfo;
import com.bcits.usecase.beans.ConsumerCurrentBill;
import com.bcits.usecase.beans.ConsumerInfoBean;
import com.bcits.usecase.beans.EmployeeMaster;
import com.bcits.usecase.beans.MonthlyConsumption;

public interface EmployeeService {
	public List<ConsumerInfoBean> getAllConsumers();

	public EmployeeMaster authenticate(Integer empId, String password);
	public List<ConsumerInfoBean> getRegionWiseConsumers(String region);
	public boolean generateBill(ConsumerCurrentBill consumerCurrentBill,String rrNo);

	public List<CommentsInfo> getComments(String region);

	public List<MonthlyConsumption> getMonthlyConsumption(String region);
	public List<BillHistory> getMonthlyRevenue(String region);
	public AdminInfoBean authenticate(int adminId, String password);
	public boolean addEmployee(EmployeeMaster employeeMaster);
	}

