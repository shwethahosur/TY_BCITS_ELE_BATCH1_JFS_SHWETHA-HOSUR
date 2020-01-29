package com.bcits.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bcits.springrest.beans.EmployeeInfoBean;
import com.bcits.springrest.beans.EmployeeResponse;
import com.bcits.springrest.service.EmployeeService;

//@Controller
@RestController
public class EmployeeRestController {
	@Autowired
	private EmployeeService service;

//	@GetMapping(path = "/getEmployee", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
//	@ResponseBody
//	public EmployeeInfoBean getEmployee(int empId) {
//		EmployeeInfoBean employeeInfoBean = service.getEmployee(empId);
//		return employeeInfoBean;
//	}

	@GetMapping(path = "/getEmployee", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public EmployeeResponse getEmployee(int empId) {
		EmployeeInfoBean employeeInfoBean = service.getEmployee(empId);
		EmployeeResponse response = new EmployeeResponse();
		if (employeeInfoBean != null) {
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

	@GetMapping(path = "/getAllEmployees", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public EmployeeResponse getAllEmployees() {
		List<EmployeeInfoBean> employeeList = service.getallEmployees();
		EmployeeResponse employeeResponse = new EmployeeResponse();
		if (employeeList != null) {
			employeeResponse.setStatusCode(201);
			employeeResponse.setMessage("success");
			employeeResponse.setDescription("employee Id found");
			employeeResponse.setEmployeeList(employeeList);
		} else {
			employeeResponse.setStatusCode(401);
			employeeResponse.setDescription("unable to find");
			employeeResponse.setMessage("failed");
		}

		return employeeResponse;
	}

//	@DeleteMapping(path = "/deleteEmployee", produces = { MediaType.APPLICATION_XML_VALUE,
//			MediaType.APPLICATION_JSON_VALUE })
//	@ResponseBody
//	public boolean deleteEmployee(int empId) {
//		return service.deleteEmployee(empId);
//		
//	}

	@DeleteMapping(path = "/deleteEmployee/{employeeID}", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public EmployeeResponse deleteEmployee(@PathVariable(name = "employeeID") int empId) {
		boolean isDeleted = service.deleteEmployee(empId);
		EmployeeResponse response = new EmployeeResponse();
		if (isDeleted) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("employee Id deleted successfully");

		} else {
			response.setStatusCode(401);
			response.setDescription("unable to delete");
			response.setMessage("failed");
		}

		return response;
	}

	@PostMapping(path = "/addEmployee", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public EmployeeResponse addEmployee(@RequestBody EmployeeInfoBean employeeInfoBean) {
		boolean isAdded = service.addEmployee(employeeInfoBean);
		EmployeeResponse response = new EmployeeResponse();
		if (isAdded) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("employee Id found");

		} else {
			response.setStatusCode(401);
			response.setDescription("unable to find");
			response.setMessage("failed");
		}

		return response;
	}

	@PutMapping(path = "/updateEmployee", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public EmployeeResponse updateEmployee(@RequestBody EmployeeInfoBean employeeInfoBean) {
		boolean isUpdated = service.addEmployee(employeeInfoBean);
		EmployeeResponse response = new EmployeeResponse();
		if (isUpdated) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("employee Id found and updated");

		} else {
			response.setStatusCode(401);
			response.setDescription("unable to update");
			response.setMessage("failed");
		}

		return response;
	}

}
