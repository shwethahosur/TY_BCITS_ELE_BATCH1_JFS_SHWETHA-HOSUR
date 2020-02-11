package com.bcits.usecase.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.bcits.usecase.beans.BillHistory;
import com.bcits.usecase.beans.BillHistoryPK;
import com.bcits.usecase.beans.CommentsInfo;
import com.bcits.usecase.beans.ConsumerCurrentBill;
import com.bcits.usecase.beans.ConsumerInfoBean;
import com.bcits.usecase.beans.MonthlyConsumption;

@Repository
public class ConsumerDAOImpl implements ConsumerDAO {
	@PersistenceUnit
	private EntityManagerFactory factory;

	@Override
	public ConsumerInfoBean authenticate(int meterNo, String password) {
		EntityManager manager = factory.createEntityManager();

		ConsumerInfoBean consumerInfoBean = manager.find(ConsumerInfoBean.class, meterNo);
		if (consumerInfoBean != null && consumerInfoBean.getUserPassword().equals(password)) {
			return consumerInfoBean;
		} else {

			return null;
		}
	}

	@Override
	public boolean addConsumer(ConsumerInfoBean consumerInfoBean) {
		EntityManager manager = factory.createEntityManager();
		if (consumerInfoBean != null) {

			EntityTransaction transaction = manager.getTransaction();
			try {
				transaction.begin();
				manager.persist(consumerInfoBean);
				transaction.commit();
			} catch (Exception e) {
				e.printStackTrace();
			}
			manager.close();

			return true;
		}
		return false;
	}

	@Override
	public ConsumerInfoBean getConsumer(int meterNo) {
		EntityManager manager = factory.createEntityManager();

		ConsumerInfoBean consumerInfoBean = manager.find(ConsumerInfoBean.class, meterNo);
		if (consumerInfoBean != null) {

			manager.close();
			return consumerInfoBean;
		}
		return null;
	}// End of getconsumer()

	@Override
	public ConsumerCurrentBill getBill(String rrNo) {
		EntityManager manager = factory.createEntityManager();

		ConsumerCurrentBill consumerCurrentBill = manager.find(ConsumerCurrentBill.class, rrNo);
		consumerCurrentBill.setCount(1);
		if (consumerCurrentBill != null) {
			manager.close();
			return consumerCurrentBill;
		}
		return null;
	}

	@Override
	public boolean updateConsumer(ConsumerInfoBean consumerInfoBean, int meterNo) {
		if (consumerInfoBean != null) {
			EntityManager manager = factory.createEntityManager();

			EntityTransaction transaction = manager.getTransaction();
			ConsumerInfoBean consumerInfoBean1 = manager.find(ConsumerInfoBean.class, consumerInfoBean.getMeterNo());
			transaction.begin();
			if (!consumerInfoBean.getFirstName().isEmpty()
					&& !consumerInfoBean.getFirstName().equals(consumerInfoBean1.getFirstName())
					&& consumerInfoBean.getFirstName() != null) {
				consumerInfoBean1.setFirstName(consumerInfoBean.getFirstName());
			}
			if (!consumerInfoBean.getLastName().isEmpty()
					&& !consumerInfoBean.getLastName().equals(consumerInfoBean1.getLastName())
					&& consumerInfoBean.getLastName() != null) {
				consumerInfoBean1.setLastName(consumerInfoBean.getLastName());
			}
			if (consumerInfoBean.getMobileNo() != null
					&& !consumerInfoBean.getMobileNo().equals(consumerInfoBean1.getMobileNo())) {
				consumerInfoBean1.setMobileNo(consumerInfoBean.getMobileNo());
			}
			if (!consumerInfoBean.getEmail().isEmpty() && consumerInfoBean.getEmail() != null
					&& !consumerInfoBean.getEmail().equals(consumerInfoBean1.getEmail())) {
				consumerInfoBean1.setEmail(consumerInfoBean.getEmail());
			}

			if (!consumerInfoBean.getAddress().isEmpty() && consumerInfoBean.getAddress() != null
					&& !consumerInfoBean.getAddress().equals(consumerInfoBean1.getAddress())) {
				consumerInfoBean1.setEmail(consumerInfoBean.getAddress());
			}
			if (consumerInfoBean.getUserPassword() != null
					&& !consumerInfoBean.getUserPassword().equals(consumerInfoBean1.getUserPassword())) {
				consumerInfoBean1.setUserPassword(consumerInfoBean.getUserPassword());
			}

			transaction.commit();
			return true;
		}
		return false;
	}// End of updateConsumer()

	@Override
	public List<MonthlyConsumption> showMonthlyConsumption(String rrNo) {
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createQuery("from MonthlyConsumption m where m.consumptionPK.rrNo=:rrNum");
		query.setParameter("rrNum", rrNo);
		List<MonthlyConsumption> billList = query.getResultList();
		if (billList != null) {
			return billList;
		}
		manager.close();
		return null;
	}

	@Override
	public boolean payment(String rrNo, Date date) {
//ConsumerCurrentBill consumerCurrentBill=new ConsumerCurrentBill();
		System.out.println(rrNo);
		System.out.println(date);
//		System.out.println(billAmount);
		EntityManager manager = factory.createEntityManager();
		ConsumerCurrentBill consumerCurrentBill = manager.find(ConsumerCurrentBill.class, rrNo);
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		
		BillHistory billHistory = new BillHistory();
		BillHistoryPK billHistoryPK = new BillHistoryPK();
		billHistoryPK.setDate(date);
		billHistoryPK.setRrNo(consumerCurrentBill.getRrNo());
		billHistory.setTotalamt(consumerCurrentBill.getPayableAmt());
		billHistory.setUnits(consumerCurrentBill.getUnits());
        billHistory.setDueamt(billHistory.getTotalamt()-consumerCurrentBill.getPayableAmt());
        billHistory.setRegion(consumerCurrentBill.getRegion());
//		if(consumerCurrentBill.getCount()==1) {
//			consumerCurrentBill.setCount(0);
//			
//			
//		}else {
//			
//			System.out.println("paid now");
//		}
    	billHistory.setStatus("paid");
		billHistory.setBillHistoryPK(billHistoryPK);
		System.out.println(billHistoryPK);
		System.out.println(billHistory);
		if (billHistoryPK != null) {
			
			manager.persist(billHistory);
			transaction.commit();
			return true;

		}
		return false;

	}

	@Override
	public boolean addComments(CommentsInfo commentsInfo) {
		EntityManager manager = factory.createEntityManager();

		if (commentsInfo != null) {
			EntityTransaction transaction = manager.getTransaction();
			CommentsInfo coInfo = manager.find(CommentsInfo.class, commentsInfo.getRrNo());
			if (coInfo != null) {
				try {
					transaction.begin();
					coInfo.setComments(commentsInfo.getComments());
					transaction.commit();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				try {
					transaction.begin();
					manager.persist(commentsInfo);
					transaction.commit();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			manager.close();
			return true;
		}
		return true;

	}// End of class
}