package com.bcits.usecase.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcits.usecase.beans.CommentsInfo;
import com.bcits.usecase.beans.ConsumerCurrentBill;
import com.bcits.usecase.beans.ConsumerInfoBean;
import com.bcits.usecase.beans.MonthlyConsumption;
import com.bcits.usecase.dao.ConsumerDAO;
import com.bcits.usecase.exception.ConsumerException;

@Service
public class ConsumerServiceImpl implements ConsumerService {
	@Autowired
	private ConsumerDAO dao;

	@Override
	public boolean addConsumer(ConsumerInfoBean consumerInfoBean) {
		// TODO Auto-generated method stub
		return dao.addConsumer(consumerInfoBean);
	}

	@Override
	public ConsumerInfoBean authenticate(int meterNo, String password) {
		// TODO Auto-generated method stub
		return dao.authenticate(meterNo, password);
	}

	@Override
	public ConsumerInfoBean getConsumer(int meterNo) {
		ConsumerInfoBean consumerInfoBean = dao.getConsumer(meterNo);
		try {
		if (meterNo < 1) {
//			throw new ConsumerException("Invalid meterNo");
		}
		
		if (consumerInfoBean == null) {
//			throw new ConsumerException("meter no.not found");
		}
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		return consumerInfoBean;
		
	}// End of getEmployee()

	@Override
	public ConsumerCurrentBill getBill(String rrNo) {

		ConsumerCurrentBill consumerCurrentBill = dao.getBill(rrNo);

		return consumerCurrentBill;
	}
	@Override
	public boolean updateConsumer(ConsumerInfoBean consumerInfoBean,int meterNo) {

		return dao.updateConsumer(consumerInfoBean,meterNo);
	}

	@Override
	public List<MonthlyConsumption> showMonthlyConsumption(String rrNo) {
		// TODO Auto-generated method stub
		return dao.showMonthlyConsumption(rrNo);
	}

//	@Override
//	public boolean payment(String rrNo, Date date) {
//		// TODO Auto-generated method stub
//		return dao.payment(rrNo, date);
//	}

	@Override
	public boolean addComments(CommentsInfo commentsInfo) {
		// TODO Auto-generated method stub
		return dao.addComments(commentsInfo);
	}

	@Override
	public boolean payment(String rrNo, Date date) {
		// TODO Auto-generated method stub
		return dao.payment(rrNo, date);
	}

}
