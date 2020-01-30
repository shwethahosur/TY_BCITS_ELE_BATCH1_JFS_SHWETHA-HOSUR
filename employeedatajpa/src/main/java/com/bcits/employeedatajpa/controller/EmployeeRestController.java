package com.bcits.employeedatajpa.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

import com.bcits.employeedatajpa.beans.EmployeeInfoBean;
import com.bcits.employeedatajpa.beans.EmployeeResponse;
import com.bcits.employeedatajpa.repository.EmployeeRepository;

@RestController
public class EmployeeRestController {

	@Autowired
	private EmployeeRepository repository;

	@GetMapping(path = "/getEmployee", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })

	public EmployeeResponse getEmployee(int empId) {
//		EmployeeInfoBean employeeInfoBean = repository.findById(empId).get();
		Optional<EmployeeInfoBean>op=repository.findById(empId);
		EmployeeResponse response = new EmployeeResponse();
//		if (employeeInfoBean != null) {
		if(op.isPresent()) {
			EmployeeInfoBean employeeInfoBean=op.get();
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("employee Id found");
			response.setEmployeeInfoBean(employeeInfoBean);
		} else {
			response.setStatusCode(401);
			response.setDescription("unable to find");
			response.setMessage("failed");
		}

		return response;
	}// end
	
	
	@GetMapping(path = "/findEmployee", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })

	public EmployeeResponse FindByempId(int empId,String password) {
//		EmployeeInfoBean employeeInfoBean = repository.findById(empId).get();
		EmployeeInfoBean op=repository.findEmployee(empId,password);
		EmployeeResponse response = new EmployeeResponse();
//		if (employeeInfoBean != null) {
		if(op!=null) {
			
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("employee Id found");
			response.setEmployeeInfoBean(op);
		} else {
			response.setStatusCode(401);
			response.setDescription("unable to find");
			response.setMessage("failed");
		}

		return response;
	}// end
	
}
