package com.bcits.springmvc1.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.bcits.springmvc1.Interfaces.EmployeeDAO;
import com.bcits.springmvc1.Interfaces.implementation.AddEmployee;
import com.bcits.springmvc1.bean.EmployeeInfoBean;
import com.bcits.springmvc1.services.EmployeeService;

@Controller

public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	@GetMapping("/login")
	public String displayLoginForm() {
		return "empLoginForm";
	}

	@PostMapping("/login")
	public String authenticate(int empid, String password, HttpServletRequest req, ModelMap modelMap) {
		
		EmployeeInfoBean bean = service.authenticate(empid, password);

		if (bean != null) {
			// valid credentials
			HttpSession session = req.getSession(true);
			session.setAttribute("loggedInEmpInfo", bean);
			return "employeeHome";
		} else {
			modelMap.addAttribute("errmsg", "invalid credentials");
			return "empLoginForm";
		}

	}

	@GetMapping("/searchEmp")
	public String displaySearchEmpForm(HttpSession session, ModelMap modelMap) {
		if (session.isNew()) {
			// user not logged in
			session.invalidate();
			modelMap.addAttribute("errmsg", "please login first");
			return "empLoginForm";
		} else {
			// user already loggedin
			return "searchEmp";
		}
	}

	@GetMapping("/search")
	public String searchEmployee(int empid,String password,HttpSession session,ModelMap modelMap) {
		if(session.getAttribute("loggedInEmpInfo")!=null) {
		
		
		EmployeeInfoBean employeeInfoBean=service.getEmployee(empid);
		if(employeeInfoBean!=null) {
			modelMap.addAttribute("employeeInfoBean", employeeInfoBean);
		}else {
			modelMap.addAttribute("errmsg", "empid not found");
		}
		return "searchEmp";
		
	} else {
		modelMap.addAttribute("errmsg", "please login first");
		return "empLoginForm";
	}
	}
	
	@GetMapping("/deleteEmployeeForm")
	public String displayDeleteEmpForm(
		@SessionAttribute(name="loggedInEmpInfo",required=false)EmployeeInfoBean employeeInfoBean,
		ModelMap modelMap){
			if(employeeInfoBean!=null) {
				return "deleteEmployee";
			}else {
				modelMap.addAttribute("errmsg", "please login first");
				return"empLoginForm";
			}
		}
	
	
	@GetMapping("/delete")
	public String deleteEmp(int empid,@SessionAttribute(name="loggedInEmpInfo",required = false)EmployeeInfoBean employeeInfoBean,ModelMap modelMap) {
		if(employeeInfoBean!=null) {
			if(service.deleteEmployee(empid)) {
				modelMap.addAttribute("msg", "emp record deleted successfully");
			}else {
				modelMap.addAttribute("errmsg", "emp id not found");
			}
			
			return "deleteEmployee";
		}else {
			
			modelMap.addAttribute("errmsg", "please login first");
			return"empLoginForm";
	
	

	}
}
	@GetMapping("/logout")
	public String logout(HttpSession session,ModelMap modelMap) {
		session.invalidate();
		modelMap.addAttribute("errmsg", "you are successfully logged out");
		return "empLoginForm";
	}
}