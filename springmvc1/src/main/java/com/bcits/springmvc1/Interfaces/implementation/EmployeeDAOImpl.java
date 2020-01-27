package com.bcits.springmvc1.Interfaces.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.bcits.springmvc1.bean.EmployeeInfoBean;


@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
	@PersistenceUnit
	private EntityManagerFactory factory;

//	@PersistenceContext
//	private EntityManager manager;
//	
	
	@Override
	public boolean addEmployee(EmployeeInfoBean employeeInfoBean) {
		EntityManager manager = factory.createEntityManager();

		if (employeeInfoBean != null) {

			EntityTransaction transaction = manager.getTransaction();
			try {
				transaction.begin();
				manager.persist(employeeInfoBean);
				transaction.commit();
			} catch (Exception e) {
				e.printStackTrace();
			}
//			manager.close();
			
			return true;
		}
		return false;
	}// End of addEmployee()

	@Override
	public boolean deleteEmployee(int empid) {
		EntityManager manager = factory.createEntityManager();

		EmployeeInfoBean employeeInfoBean = manager.find(EmployeeInfoBean.class, empid);
		if (employeeInfoBean != null) {

			EntityTransaction transaction = manager.getTransaction();
			try {
				transaction.begin();
				manager.remove(employeeInfoBean);
				transaction.commit();
			} catch (Exception e) {
				e.printStackTrace();
			}
//			manager.close();
			return true;
		}
		return false;
	}// End of deleteEmployee()

	@Override
	public EmployeeInfoBean getEmployee(int empid) {
		EntityManager manager = factory.createEntityManager();

		EmployeeInfoBean employeeInfoBean = manager.find(EmployeeInfoBean.class, empid);
		if (employeeInfoBean != null) {

//			manager.close();
			return employeeInfoBean;
		}
		return null;
	}// End of getEmployee()

	@Override
	public List<EmployeeInfoBean> getAllEmployees() {
		EntityManager manager = factory.createEntityManager();

		String jpql = "from EmployeeInfoBean";
		Query query = manager.createQuery(jpql);
		List<EmployeeInfoBean> list = query.getResultList();
		manager.close();
		return list;
	}// End of getAllEmployees()

	@Override
	public boolean updateEmployee(EmployeeInfoBean employeeInfoBean) {
		// TODO Auto-generated method stub
		return false;
	}//End of updateEmployee() 

	@Override
	public EmployeeInfoBean authenticate(int empid,String password) {
		EntityManager manager = factory.createEntityManager();

		EmployeeInfoBean employeeInfoBean=manager.find(EmployeeInfoBean.class, empid);
		if(employeeInfoBean!=null&& employeeInfoBean.getPassword().equals(password)) {
			return employeeInfoBean;
		}else {
			
			return null;
		}
	}//End of authenticate()

}// End of class

