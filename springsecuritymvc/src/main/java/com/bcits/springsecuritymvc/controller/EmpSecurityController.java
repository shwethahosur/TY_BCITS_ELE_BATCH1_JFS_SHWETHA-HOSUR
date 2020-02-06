package com.bcits.springsecuritymvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bcits.springsecuritymvc.beans.EmpInfoBean;
import com.bcits.springsecuritymvc.service.EmpService;

@Controller
public class EmpSecurityController {
	@Autowired
	private EmpService service;

	@GetMapping("/index")
	public String getIndexPage() {
		return "index";
	}

	@GetMapping("/register")
	public String getRegisterForm() {
		return "register";
	}

	@PostMapping("/register")
	public String register(EmpInfoBean infoBean, ModelMap modelMap) {
		boolean isRegistered = service.register(infoBean);
		if (isRegistered) {
			modelMap.addAttribute("msg", "registered successfully");

		} else {
			modelMap.addAttribute("errmsg", "registeration failed");
		}
		return "register";
	}

	@GetMapping("/adminSecureHome")
	public String getadminForm() {
		return "adminHome";
	}

	@GetMapping("/userSecureHome")
	public String getuserForm() {
		return "userHome";
	}
	
	@GetMapping("/getEmployeeForm")
	public String getEmpForm() {
		return "search";
	}
	
	
	@GetMapping("/getEmployee")
	public String getEmployee(int empId,ModelMap modelMap) {
		EmpInfoBean infoBean=service.getEmployee(empId);
		modelMap.addAttribute("empInfo", infoBean);
		return "search";
	}
	@GetMapping("/getAllEmployees")
	public String getAllEmployees(ModelMap modelMap) {
		
		modelMap.addAttribute("employeeList", service.getAllEmployees());
		return "getAllEmployees";
	}

}
