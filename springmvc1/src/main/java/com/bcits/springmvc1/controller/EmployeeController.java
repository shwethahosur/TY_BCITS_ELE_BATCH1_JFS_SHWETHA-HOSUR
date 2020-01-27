package com.bcits.springmvc1.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.bcits.springmvc1.bean.EmployeeInfoBean;
import com.bcits.springmvc1.services.EmployeeService;


@Controller
public class EmployeeController {
	
	
	@InitBinder
	public void initBinder (WebDataBinder binder) {
		CustomDateEditor dateEditor=new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true);
		binder.registerCustomEditor(Date.class, dateEditor);
	}
	
	@Autowired
	private EmployeeService service;

	@GetMapping("/login")
	public String displayLogin() {
		System.out.println("inside get mapping");
		return "empLoginForm";
	}// End of displayLogin()

	@PostMapping("/login")
	public String authenticate(int empid, String password, ModelMap map, HttpServletRequest req) {
System.out.println("inside post mapping");
		EmployeeInfoBean employeeInfoBean = service.authenticate(empid, password);
		if (employeeInfoBean != null) {
			// valid credentials
			HttpSession session = req.getSession(true);
			session.setAttribute("loggedInEmpInfo", employeeInfoBean);

			return "employeeHome";
		} else {
			// Invalid credentials
			map.addAttribute("errmsg", "Invalid Credentials");
			return "empLoginForm";
		}
	}// End of authenticate()

	@GetMapping("/searchEmpForm")
	public String displayEmployeeForm(HttpSession session, ModelMap map) {
		if (session.isNew()) {
			// user not logged in
			session.invalidate();

			map.addAttribute("errmsg", "Please LogIn first");
			return "empLoginForm";
		} else {
			// user already logged
			return "searchEmp";
		}
	}// End of displayEmployeeForm()

	@GetMapping("/search")
	public String searchEmployee(int empid, HttpSession session, ModelMap modelMap) {
		if (session.getAttribute("loggedInEmpInfo") != null) {
			// valid session

			EmployeeInfoBean employeeInfoBean = service.getEmployee(empid);
			if (employeeInfoBean != null) {
				modelMap.addAttribute("employeeInfoBean", employeeInfoBean);

			} else {
				modelMap.addAttribute("errmsg", "Employee Id not found");
			}
			return "searchEmp";
		} else {
			// Invalid session
			modelMap.addAttribute("errmsg", "please login First");
			return "empLoginForm";
		}
	}// End of searchEmployee()

	@GetMapping("/deleteEmpForm")
	public String displayDeleteEmployeeForm(
			@SessionAttribute(name = "loggedInEmpInfo", required = false) EmployeeInfoBean employeeInfoBean,
			ModelMap modelMap) {
		if (employeeInfoBean != null) {
			// valid session
			return "deleteEmployee";
		} else {
			// invalid session
			modelMap.addAttribute("errmsg", "Please login first");
			return "empLoginForm";
		}
	}// End of displayDeleteEmployeeForm()

	@GetMapping("/delete")
	public String deleteEmployee(int empid,
			@SessionAttribute(name = "loggedInEmpInfo") EmployeeInfoBean employeeInfoBean, ModelMap modelMap) {
		if (employeeInfoBean != null) {
			// valid session
			if (service.deleteEmployee(empid)) {
				modelMap.addAttribute("msg", "Employee Record Deleted Successfully...");
			} else {
				modelMap.addAttribute("errmsg", "Employee Record Not Found");
			}
			return "deleteEmployee";
		} else {
			// invalid session
			modelMap.addAttribute("errmsg", "Please login first");
			return "empLoginForm";
		}
	}// End of deleteEmployee()

	@GetMapping("/logout")
	public String logout(HttpSession session, ModelMap map) {
		session.invalidate();
		map.addAttribute("errmsg", "you are successfully logged out");
		return "empLoginForm";
	}// End of logout()
	

	
	@GetMapping("/updateEmpForm")
	public String displayUpdateEmployeeForm(
			@SessionAttribute(name = "loggedInEmpInfo", required = false) EmployeeInfoBean employeeInfoBean,
			ModelMap modelMap) {
		if (employeeInfoBean != null) {
			// valid session
			return "updateEmployee";
		} else {
			// invalid session
			modelMap.addAttribute("errmsg", "Please login first");
			return "empLoginForm";
		}
	}// End of displayupdateEmployeeForm()

	@GetMapping("/update")
	public String updateEmployee(int empid,
			@SessionAttribute(name = "loggedInEmpInfo") EmployeeInfoBean employeeInfoBean, ModelMap modelMap) {
		if (employeeInfoBean != null) {
			// valid session
			if (service.deleteEmployee(empid)) {
				modelMap.addAttribute("msg", "Employee Record updated Successfully...");
			} else {
				modelMap.addAttribute("errmsg", "Employee Record Not Found");
			}
			return "updateEmployee";
		} else {
			// invalid session
			modelMap.addAttribute("errmsg", "Please login first");
			return "empLoginForm";
		}
	}// End of updateEmployee()

	@GetMapping("/getEmpForm")
	public String displaygetallEmployeeForm(
			@SessionAttribute(name = "loggedInEmpInfo", required = false) EmployeeInfoBean employeeInfoBean,
			ModelMap modelMap) {
	List<EmployeeInfoBean>list	=service.getallEmployees();
		if (employeeInfoBean != null) {
			// valid session
			return "";
		} else {
			// invalid session
			modelMap.addAttribute("errmsg", "Please login first");
			return "empLoginForm";
		}
	}// End of displayupdateEmployeeForm()

	
	
	
	
	

}// End of class

