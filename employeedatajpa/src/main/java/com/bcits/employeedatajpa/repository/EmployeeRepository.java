package com.bcits.employeedatajpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.bcits.employeedatajpa.beans.EmployeeInfoBean;

public interface EmployeeRepository extends CrudRepository<EmployeeInfoBean, Integer> {

//	@Query("from EmployeeInfoBean where empId=?1 and password=?2")
//	public EmployeeInfoBean findByempId(int empID,String password);

	@Query("from EmployeeInfoBean where empId=:id and password=:pwd")
	public EmployeeInfoBean findEmployee(int id, @Param("pwd") String password);

}
