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

import com.bcits.usecase.beans.CommentsInfo;
import com.bcits.usecase.beans.ConsumerCurrentBill;
import com.bcits.usecase.beans.ConsumerInfoBean;
import com.bcits.usecase.beans.EmployeeMaster;
import com.bcits.usecase.beans.MonthlyConsumption;
import com.bcits.usecase.service.ConsumerService;

@Controller
public class ConsumerController {
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		CustomDateEditor dateEditor = new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true);
		binder.registerCustomEditor(Date.class, dateEditor);
	}

	@Autowired
	private ConsumerService consumerService;

	@GetMapping("/homepage")
	public String displayHomePage() {
		return "Homepage";
	}

	@GetMapping("/signup")
	public String displayConsumerSignUpPage() {

		return "consumersSignup";
	}

	@PostMapping("/login")
	public String authenticate(int meterNo, String password, ModelMap map, HttpServletRequest req) {

		ConsumerInfoBean consumerInfoBean = consumerService.authenticate(meterNo, password);
		if (consumerInfoBean != null) {
			// valid credentials
			HttpSession session = req.getSession(true);
			session.setAttribute("loggedInConsInfo", consumerInfoBean);

			return "SearchConsumerForm";
		} else {
			// Invalid credentials
			map.addAttribute("errMsg", "Invalid Credentials");
			return "conslogin";
		}
	}// End of authenticate()

	@PostMapping("/addConsumer")
	public String addEmployee(ConsumerInfoBean consumerInfoBean, ConsumerInfoBean consumerInfoBean1,
			ModelMap modelMap) {
		if (consumerInfoBean != null) {
			// valid session
			if (consumerService.addConsumer(consumerInfoBean1)) {
				modelMap.addAttribute("msg", "signup Successfull...");
			} else {
				modelMap.addAttribute("errMsg", "Consumer Record Not added");
			}
			return "conslogin";
		} else {
			// invalid session
			modelMap.addAttribute("errMsg", "Please login first");
			return "conslogin";
		}
	}

	@GetMapping("/consumerlogin")
	public String displayConsumerloginPage() {
		return "conslogin";
	}

	@GetMapping("/SearchConsumerForm")
	public String displayConsumerForm(HttpSession session, ModelMap map) {
		if (session.isNew()) {
			// user not logged in
			session.invalidate();

			map.addAttribute("errMsg", "Please LogIn first");
			return "conslogin";
		} else {
			// user already logged
			return "SearchConsumerForm";
		}
	}// End of displaySearchConsumerForm()

	@GetMapping("/search")
	public String searchConsumer(int meterNo, HttpSession session, ModelMap modelMap) {
		if (session.getAttribute("loggedInConsInfo") != null) {
			// valid session

			ConsumerInfoBean consumerInfoBean = consumerService.getConsumer(meterNo);
			if (consumerInfoBean != null) {
				modelMap.addAttribute("consumerInfoBean", consumerInfoBean);

			} else {
				modelMap.addAttribute("errMsg", "meter no. not found");
			}
			return "SearchConsumerForm";
		} else {
			// Invalid session
			modelMap.addAttribute("errMsg", "please login First");
			return "conslogin";
		}
	}// End of searchSearchConsumer()

	@GetMapping("/billDetails")
	public String displayBillDetails(HttpSession session, ModelMap map) {
		if (session.isNew()) {
			// user not logged in
			session.invalidate();

			map.addAttribute("errMsg", "Please LogIn first");
			return "conslogin";
		} else {
			// user already logged
			return "billDetails";
		}
	}// End of displaySearchConsumerForm()

	@GetMapping("/bill")
	public String BillDetails(String rrNo, HttpSession session, ModelMap modelMap) {
		if (session.getAttribute("loggedInConsInfo") != null) {
			// valid session

			ConsumerCurrentBill consumerCurrentBill = consumerService.getBill(rrNo);
			System.out.println(consumerCurrentBill);
			if (consumerCurrentBill != null) {
				modelMap.addAttribute("consumerCurrentBill", consumerCurrentBill);

			} else {
				modelMap.addAttribute("errMsg", "rr no. not found");
			}
			return "billDetails";
		} else {
			// Invalid session
			modelMap.addAttribute("errMsg", "please login First");
			return "conslogin";
		}
	}// End of searchSearchConsumer()

	@GetMapping("/updateConsumerForm")
	public String updateConsForm(HttpSession session, ModelMap map) {
		if (session.isNew()) {
			// user not logged in
			session.invalidate();

			map.addAttribute("errMsg", "Please LogIn first");
			return "conslogin";
		} else {
			// user already logged
			return "updateConsumerForm";
		}
	}// End of updateEmpForm()

	@PostMapping("/updateConsumer")
	public String updateConsumer(HttpSession session, ModelMap modelMap, ConsumerInfoBean consumerInfoBean,
			int meterNo) {
		if (session.getAttribute("loggedInConsInfo") != null) {
			// valid session
			if (consumerService.updateConsumer(consumerInfoBean, meterNo)) {
				modelMap.addAttribute("msg", "Consumer Record updated Successfully...");
			} else {
				modelMap.addAttribute("errMsg", "Consumer Record Not updated");
			}
			return "updateConsumerForm";
		} else {
			// Invalid session
			modelMap.addAttribute("errMsg", "please login First");
			return "conslogin";
		}

	}

	@GetMapping("/payForm")
	public String payBill(HttpSession session, ModelMap map) {
		if (session.isNew()) {
			// user not logged in
			session.invalidate();

			map.addAttribute("errMsg", "Please LogIn first");
			return "conslogin";
		} else {
			// user already logged
			return "payment";
		}
	}// End of updateEmpForm()

	@GetMapping("/monthlyConsumption")
	public String displayMonthlyConsumption(HttpSession session, ModelMap modelMap) {
		ConsumerInfoBean consumerInfoBean = (ConsumerInfoBean) session.getAttribute("loggedInConsInfo");
		// valid session
		if (consumerInfoBean != null) {
			List<MonthlyConsumption> monthlyList = consumerService.showMonthlyConsumption(consumerInfoBean.getRrNo());

			if (monthlyList != null) {
				modelMap.addAttribute("monthlyConsumption", monthlyList);

			} else {
				modelMap.addAttribute("errMsg", "service unavailable");
			}
			return "monthlyConsumption";
		} else {
			// Invalid session
			modelMap.addAttribute("errMsg", "please login First");
			return "conslogin";
		}
	}// End of searchSearchConsumer()

	@PostMapping("/payBill")
	public String displayPayBill(HttpSession session, ModelMap modelMap,ConsumerCurrentBill consumerCurrentBill) {

		ConsumerInfoBean consumerInfoBean = (ConsumerInfoBean) session.getAttribute("loggedInConsInfo");
//		EmployeeMaster employeeMaster=(EmployeeMaster) session.getAttribute("loggedInConsInfo");
		Date date = new Date();
		if (consumerInfoBean != null) {
			System.out.println(date);
			System.out.println(consumerCurrentBill.getRrNo());
			boolean pay = consumerService.payment(consumerInfoBean.getRrNo(), date);
			System.out.println(pay);
			if (pay == true) {
				
				modelMap.addAttribute("msg", "payment successfull");
				return "payment";
			} else {
				modelMap.addAttribute("errmsg", "payment not success");
				return "payment";
			}
		} else {
			return "conslogin";
		}

	}
	
	@GetMapping("/commentsPage")
	public String commentsPage(HttpSession session, ModelMap modelMap) {
		if (session.getAttribute("loggedInConsInfo") != null) {
			// valid details
			return "commentsPage";
		} else {
			// Invalid Session
			modelMap.addAttribute("errMsg", "Please Login First");
			return "conslogin";
		}
	}// End of contactUsPage()

	@PostMapping("/contactUs")
	public String contactUs(HttpSession session, ModelMap modelMap, CommentsInfo commentsInfo) {
		ConsumerInfoBean consumerInfoBean = (ConsumerInfoBean) session.getAttribute("loggedInConsInfo");
		if (consumerInfoBean != null) {
			// Valid Session
			commentsInfo.setRrNo(consumerInfoBean.getRrNo());
			if (consumerService.addComments(commentsInfo)) {

				modelMap.addAttribute("msg", "Comments ");
			} else {
				modelMap.addAttribute("errMsg", " Request failed..");
			}
			return "commentsPage";
		} else {
			// Invalid Session
			modelMap.addAttribute("errMsg", "Please Login First");
			return "conslogin";
		}

	}// End of comments()
	
	

	@GetMapping("/consumerLogoutPage")
	public String consumerLogOut(ModelMap modelMap, HttpSession session) {
		session.invalidate();
		modelMap.addAttribute("Msg", "You Are Sucessfully Logged Out !!");
		return "Homepage";
	}// End of logout()
	

	
	
	
}
