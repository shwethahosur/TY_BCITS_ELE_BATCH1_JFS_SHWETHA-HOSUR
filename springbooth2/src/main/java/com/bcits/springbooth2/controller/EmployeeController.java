package com.bcits.springbooth2.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bcits.springbooth2.beans.EmployeeInfoBean;
import com.bcits.springbooth2.repository.EmployeeRepository;
@RestController
public class EmployeeController {

@Autowired
private EmployeeRepository repository;

@GetMapping(path = "/getEmployee",produces =MediaType.APPLICATION_JSON_VALUE)

public EmployeeInfoBean getEmployee(int empId) {
	Optional<EmployeeInfoBean>employee=repository.findById(empId);
	if(employee.isPresent()) {
		return employee.get();
	}else {
		return null;
	}
}
	@PostMapping(path="/addEmployee",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	
	public EmployeeInfoBean addEmployee(@RequestBody EmployeeInfoBean employeeInfoBean) {
		EmployeeInfoBean infoBean=repository.save(employeeInfoBean);
		return infoBean;
	}


	@PutMapping(path="/updateEmployee",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
		public EmployeeInfoBean updateEmployee(@RequestBody EmployeeInfoBean employeeInfoBean) {
		EmployeeInfoBean infoBean=repository.save(employeeInfoBean);
		return infoBean;
	}
	
	
	@DeleteMapping(path="/deleteEmployee",produces = MediaType.APPLICATION_JSON_VALUE)
	
	public EmployeeInfoBean deleteEmployee(int empId) {
		Optional<EmployeeInfoBean> op=repository.findById(empId);
		if(op.isPresent()) {
			repository.deleteById(empId);
			return op.get();
		}else {
			return null;
		}
		
		
		
	}
	
}
