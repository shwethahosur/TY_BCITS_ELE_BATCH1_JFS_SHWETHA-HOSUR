package com.bcits.usecase.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.hibernate.hql.spi.id.IdTableInfo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.bcits.usecase.beans.AdminInfoBean;
import com.bcits.usecase.beans.BillHistory;
import com.bcits.usecase.beans.CommentsInfo;
import com.bcits.usecase.beans.ConsumerCurrentBill;
import com.bcits.usecase.beans.ConsumerInfoBean;
import com.bcits.usecase.beans.EmployeeMaster;
import com.bcits.usecase.beans.MonthlyConsumption;
import com.bcits.usecase.beans.MonthlyConsumptionPK;
import com.bcits.usecase.mail.MailMail;
import com.bcits.usecase.test.BillCalculator;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
	@PersistenceUnit
	private EntityManagerFactory factory;
	@Override
	public AdminInfoBean authenticate(int adminId, String password) {
		EntityManager manager = factory.createEntityManager();

		AdminInfoBean adminInfoBean = manager.find(AdminInfoBean.class, adminId);
		if (adminInfoBean != null && adminInfoBean.getPassword().equals(password)) {
			return adminInfoBean;
		} else {

			return null;
		}
	}

	@Override
	public boolean addEmployee(EmployeeMaster employeeMaster) {
		EntityManager manager = factory.createEntityManager();
		if (employeeMaster != null) {

			EntityTransaction transaction = manager.getTransaction();
			try {
				transaction.begin();
				manager.persist(employeeMaster);
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
	public List<ConsumerInfoBean> getAllConsumers() {
		EntityManager manager = factory.createEntityManager();

		String jpql = "from ConsumerInfoBean";
		Query query = manager.createQuery(jpql);
		List<ConsumerInfoBean> list = query.getResultList();
		manager.close();
		return list;
	}// End of getAllConsumers()

	@Override
	public EmployeeMaster authenticate(Integer empId, String password) {
		EntityManager manager = factory.createEntityManager();

		EmployeeMaster employeeMaster = manager.find(EmployeeMaster.class, empId);
		if (employeeMaster != null && employeeMaster.getPassword().equals(password)) {
			return employeeMaster;
		} else {

			return null;
		}
	}

	@Override
	public List<ConsumerInfoBean> getRegionWiseConsumers(String region) {
		EntityManager manager = factory.createEntityManager();
		String jpql = "from ConsumerInfoBean where region=:regionName";
		Query query = manager.createQuery(jpql);
		query.setParameter("regionName", region);
		List<ConsumerInfoBean> list = query.getResultList();
		manager.close();
		return list;
	}

	@Override
	public boolean generateBill(ConsumerCurrentBill consumerCurrentBill, String rrNo) {
		Integer initread = 0;
		Integer unitsConsumed = 0;
//		boolean isBillGenerated = false;
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		ConsumerCurrentBill bill = manager.find(ConsumerCurrentBill.class, consumerCurrentBill.getRrNo());
		String jpql = " from ConsumerInfoBean where rrNo=:rrNumber";
		Query query = manager.createQuery(jpql);
		query.setParameter("rrNumber", consumerCurrentBill.getRrNo());
		ConsumerInfoBean consumerInfoBean = (ConsumerInfoBean) query.getSingleResult();

		if (consumerInfoBean != null) {
			if (bill != null) {
				initread = bill.getCurrentMeterReading();
				MonthlyConsumption monthlyConsumption = new MonthlyConsumption();
				monthlyConsumption.setBillAmount(bill.getPayableAmt());
				monthlyConsumption.setRegion(bill.getRegion());
				monthlyConsumption.setUnitsConsumed(bill.getUnits());
				MonthlyConsumptionPK monthlyConsumptionPK = new MonthlyConsumptionPK();
				monthlyConsumptionPK.setRrNo(bill.getRrNo());
				monthlyConsumptionPK.setDate(bill.getCurrentMeterReadDate());
				monthlyConsumption.setConsumptionPK(monthlyConsumptionPK);
				transaction.begin();
				manager.persist(monthlyConsumption);
				transaction.commit();

				unitsConsumed = consumerCurrentBill.getCurrentMeterReading() - initread;
				try {
					BillCalculator billCalculator = new BillCalculator();
					Double amount = (billCalculator.calculateBill(unitsConsumed, consumerInfoBean.getConsumertype()));

					transaction.begin();

					bill.setPreviousMeterReading(initread);
					bill.setUnits(unitsConsumed);
//					bill.setCount(1);
					bill.setPayableAmt(amount);
					bill.setCurrentMeterReadDate(consumerCurrentBill.getCurrentMeterReadDate());
					bill.setDueDate(consumerCurrentBill.getDueDate());
					bill.setCurrentMeterReading(consumerCurrentBill.getCurrentMeterReading());
//					bill.setPreviousMeterReading(consumerCurrentBill.getPreviousMeterReading());
                    
					System.out.println("units consumed");
					transaction.commit();
					
			ApplicationContext context=new ClassPathXmlApplicationContext("discom-bean.xml");
			double cAmount=consumerCurrentBill.getPayableAmt();
		MailMail mm=(MailMail)context.getBean("mailMail");
			mm.sendEmail("shwethahosur1997@gmail.com",consumerInfoBean.getEmail(),"current bill",
					("rrNo="+consumerCurrentBill.getRrNo()+"\n contact Number="+consumerInfoBean.getMobileNo()
					+"\n Consumed Units="+consumerCurrentBill.getUnits()
					+consumerCurrentBill.getPreviousMeterReading()+"\n initial units="
					+consumerCurrentBill.getCurrentMeterReading()+"\n Final Units"
					+consumerCurrentBill.getDueDate()+"\n Due date"
					+consumerCurrentBill.getCurrentMeterReadDate()+"\n meter Read Date"
					+"\n current bill="+cAmount+"\n Total Bill="+cAmount));
					
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			manager.close();
			return true;
		}
		return false;
	}
	
	@Override
	public List<CommentsInfo> Comments(String region) {
		EntityManager manager = factory.createEntityManager();
		String jpql = "from CommentsInfo where region=:regionName";
		Query query = manager.createQuery(jpql);
		query.setParameter("regionName", region);
		List<CommentsInfo> list = query.getResultList();
		if (list != null && !list.isEmpty()) {
			return list;
		} else {
			return null;
		}
	}//
	
	
	@Override
	public List<MonthlyConsumption> getMonthlyConsumption(String region) {
		EntityManager manager = factory.createEntityManager();
		String jpql = " from MonthlyConsumption where region=:regionName";
		Query query = manager.createQuery(jpql);
		query.setParameter("regionName", region);
		List<MonthlyConsumption> list = query.getResultList();
		if (list != null && !list.isEmpty()) {
			return list;
		} else {
			return null;
		}
	}//End of getMonthlyConsumption()
	
	
	@Override
	public List<BillHistory> getMonthlyRevenue(String region) {
		EntityManager manager = factory.createEntityManager();
		String jpql = " SELECT date,region, SUM(totalamt)\r\n" + 
				"	FROM BillHistory b\r\n" +  
				"	GROUP BY rrNo";
			System.out.println("......."+jpql);	
		Query query = manager.createQuery(jpql);
//		query.setParameter("regionName", region);
		List<BillHistory> list = query.getResultList();
		if (list != null && !list.isEmpty()) {
			return list;
		} else {
			return null;
		}
	}//End of getMonthlyConsumption()
	
	

}
