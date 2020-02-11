package com.bcits.usecase.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
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

import com.bcits.usecase.beans.AdminInfoBean;
import com.bcits.usecase.beans.BillHistory;
import com.bcits.usecase.beans.CommentsInfo;
import com.bcits.usecase.beans.ConsumerCurrentBill;
import com.bcits.usecase.beans.ConsumerInfoBean;
import com.bcits.usecase.beans.EmployeeMaster;
import com.bcits.usecase.beans.MonthlyConsumption;
import com.bcits.usecase.service.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService service;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		CustomDateEditor dateEditor = new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true);
		binder.registerCustomEditor(Date.class, dateEditor);
	}

	@GetMapping("/employeelogin")
	public String displayemployeeloginPage() {
		return "employeeLogin";
	}

	@GetMapping("/emplogin")
	public String authenticate(Integer empId, String password, ModelMap map, HttpServletRequest req) {

		EmployeeMaster employeeMaster = service.authenticate(empId, password);
		if (employeeMaster != null) {
			// valid credentials
			HttpSession session = req.getSession(true);
			session.setAttribute("loggedInConsInfo", employeeMaster);

			return "searchRegionConsumers";
		} else {
			// Invalid credentials
			map.addAttribute("errMsg", "Invalid Credentials");
			return "employeeLogin";
		}
	}// End of authenticate()

	@GetMapping("/empSignup")
	public String displayEmpSignUpPage() {

		return "empSignUp";
	}

	@PostMapping("/adminlogin")
	public String authenticate(int adminId, String password, ModelMap map, HttpServletRequest req) {

		AdminInfoBean adminInfoBean = service.authenticate(adminId, password);
		if (adminInfoBean != null) {
			// valid credentials
			HttpSession session = req.getSession(true);
			session.setAttribute("loggedInConsInfo", adminInfoBean);

			return "empSignUp";
		} else {
			// Invalid credentials
			map.addAttribute("errMsg", "Invalid Credentials");
			return "adminLogin";
		}
	}// End of authenticate()

	@PostMapping("/addEmployee")
	public String addEmployee(EmployeeMaster employeeMaster, EmployeeMaster employeeMaster1, ModelMap modelMap) {
		if (employeeMaster != null) {
			// valid session
			if (service.addEmployee(employeeMaster1)) {
				modelMap.addAttribute("msg", "signup Successfull and record added...");
			} else {
				modelMap.addAttribute("errMsg", "Employee Record Not added");
			}
			return "empSignUp";
		} else {
			// invalid session
			modelMap.addAttribute("errMsg", "Please login first");
			return "employeeLogin";
		}
	}

	@GetMapping("/adminlogin")
	public String displayadminloginPage() {
		return "adminLogin";
	}

//	@GetMapping("/billGenerate")
//	public String displayBillGeneratePage() {
//		return "billGenerate";
//	}

//	if (monthlyConsumption != null) {
//	modelMap.addAttribute("rrNumber", rrNo);
//	modelMap.addAttribute("monthlyConsumption", monthlyConsumption);
//} else {
//	modelMap.addAttribute("rrNumber", rrNo);
//	modelMap.addAttribute("errMsg", "Details are Not Found!!");
//}
//return "empmonthlyConsumption";
//}// End of searchMonthlyConsumtionDetails()
//

	@GetMapping("/getAllConsumers")
	public String getAllConsumers(HttpSession session, ModelMap modelMap) {
		if (session.getAttribute("loggedInConsInfo") != null) {
			// valid session

			List<ConsumerInfoBean> list = service.getAllConsumers();
			if (list != null) {
				modelMap.addAttribute("consumerInfoBean", list);

			} else {
				modelMap.addAttribute("errMsg", "Consumer list not found");
			}
			return "searchAllConsumers";
		} else {
			// Invalid session
			modelMap.addAttribute("errMsg", "please login First");
			return "employeeLogin";
		}
	}// End of getAllConsumers()

	@GetMapping("/getregionConsumers")
	public String getRegionWiseConsumers(HttpSession session, ModelMap modelMap) {
		EmployeeMaster employeeMaster = (EmployeeMaster) session.getAttribute("loggedInConsInfo");
		if (employeeMaster != null) {
			// valid session

			List<ConsumerInfoBean> list = service.getRegionWiseConsumers(employeeMaster.getRegion());
			if (list != null) {
				modelMap.addAttribute("consumerInfoBean", list);
				modelMap.addAttribute("employee", employeeMaster);

			} else {
				modelMap.addAttribute("errMsg", "Consumer list not found");
			}
			return "searchRegionConsumers";
		} else {
			// Invalid session
			modelMap.addAttribute("errMsg", "please login First");
			return "employeeLogin";
		}
	}// End of getAllConsumers()

	@GetMapping("/billGenerateForm")
	public String displayBillGeneratePage(String rrNo, ConsumerInfoBean consumerInfoBean) {
		return "billGenerate";
	}

	@GetMapping("/billUpdatePage")
	public String billUpdatePage(HttpSession session, ModelMap modelMap) {
		EmployeeMaster master = (EmployeeMaster) session.getAttribute("loggedInConsInfo");
		if (master != null) {
			// Valid details
			return "employeeBillUpdatePage";
		} else {
			// Invalid details
			modelMap.addAttribute("errMsg", "Please LogIn First!!!");
			return "employeeLogin";
		}
	}

	@PostMapping("/BillGenerated")
	public String getBillGenerated(HttpSession session, ModelMap modelMap, ConsumerCurrentBill consumerCurrentBill,
			String rrNo) {
		EmployeeMaster employeeMaster = (EmployeeMaster) session.getAttribute("loggedInConsInfo");
		if (employeeMaster != null) {
			// valid session
			if (service.generateBill(consumerCurrentBill, rrNo)) {
				modelMap.addAttribute("msg", "bill updated successfully");
			} else {
				modelMap.addAttribute("errMsg", "bill updated failed");
			}
			return "employeeBillUpdatePage";
		} else {
			// Invalid session
			modelMap.addAttribute("errMsg", "please login First");
			return "employeeLogin";
		}
	}

	@GetMapping("/viewComments")
	public String getComments(HttpSession session, ModelMap modelMap) {
		EmployeeMaster employeeMaster = (EmployeeMaster) session.getAttribute("loggedInConsInfo");
		if (employeeMaster != null) {
			// Valid details
			List<CommentsInfo> list = service.getComments(employeeMaster.getRegion());
			if (list != null && !list.isEmpty()) {
				modelMap.addAttribute("list", list);

			} else {
				modelMap.addAttribute("errMsg", "Details are not found ");
			}
			return "empResponsePage";
		} else {
			// Invalid details
			modelMap.addAttribute("errMsg", "Please LogIn First!!!");
			return "employeeLogin";
		}
	}// End of getComments()

	@GetMapping("/empmonthlyConsumption")
	public String searchMonthlyConsumtionDetails(HttpSession session, ModelMap modelMap, String rrNo) {
		EmployeeMaster employeeMaster = (EmployeeMaster) session.getAttribute("loggedInConsInfo");

		List<MonthlyConsumption> monthlyConsumption = service.getMonthlyConsumption(rrNo);

		if (employeeMaster != null) {
			List<MonthlyConsumption> monthlyList = service.getMonthlyConsumption(employeeMaster.getRegion());

			if (monthlyList != null) {
				modelMap.addAttribute("monthlyConsumption", monthlyList);

			} else {
				modelMap.addAttribute("errMsg", "service unavailable");
			}
			return "empmonthlyConsumption";
		} else {
			// Invalid session
			modelMap.addAttribute("errMsg", "please login First");
			return "conslogin";
		}
	}// End of searchSearchConsumer()

	@GetMapping("/revenue")
	public String revenueDetails(HttpSession session, ModelMap modelMap, String region) {
		EmployeeMaster employeeMaster = (EmployeeMaster) session.getAttribute("loggedInConsInfo");

		List<BillHistory> monthlyrevenue = service.getMonthlyRevenue(region);

		if (employeeMaster != null) {
			List<BillHistory> monthlyList = service.getMonthlyRevenue(employeeMaster.getRegion());

			if (monthlyList != null) {
				modelMap.addAttribute("monthlyrevenue", monthlyList);

			} else {
				modelMap.addAttribute("errMsg", "service unavailable");
			}
			return "monthlyRevenue";
		} else {
			// Invalid session
			modelMap.addAttribute("errMsg", "please login First");
			return "conslogin";
		}
	}// End of searchSearchConsumer()

	@GetMapping("/empLogoutPage")
	public String consumerLogOut(ModelMap modelMap, HttpSession session) {
		session.invalidate();
		modelMap.addAttribute("Msg", "You Are Sucessfully Logged Out !!");
		return "Homepage";
	}// End of logout()

}
