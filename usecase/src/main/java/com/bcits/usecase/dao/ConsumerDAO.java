package com.bcits.usecase.dao;

import java.util.Date;
import java.util.List;

import com.bcits.usecase.beans.CommentsInfo;
import com.bcits.usecase.beans.ConsumerCurrentBill;
import com.bcits.usecase.beans.ConsumerInfoBean;
import com.bcits.usecase.beans.MonthlyConsumption;

public interface ConsumerDAO {

	public ConsumerInfoBean authenticate(int meterNo, String password);

	public boolean addConsumer(ConsumerInfoBean consumerInfoBean);
	
	public ConsumerInfoBean getConsumer(int meterNo);
	public ConsumerCurrentBill getBill(String rrNo);
	public boolean updateConsumer(ConsumerInfoBean consumerInfoBean,int meterNo);
	public List<MonthlyConsumption>showMonthlyConsumption(String rrNo);
	public boolean payment(String rrNo,Date date);
	public boolean addComments(CommentsInfo commentsInfo);



	
}
