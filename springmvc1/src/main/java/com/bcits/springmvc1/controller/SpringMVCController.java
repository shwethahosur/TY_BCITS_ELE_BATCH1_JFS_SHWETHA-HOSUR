package com.bcits.springmvc1.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bcits.springmvc1.bean.UserBean;

@Controller
public class SpringMVCController {
	@RequestMapping(path = "/hello",method = RequestMethod.GET)
public ModelAndView displayWelcomeMessage() {
		//forwarding request
	ModelAndView modelAndView=new ModelAndView();
//	modelAndView.setViewName("/WEB-INF/views/message.jsp");
	modelAndView.setViewName("message");
	return modelAndView;
}//...........
	
	
	@RequestMapping(path = "/searchEmployee", method = RequestMethod.GET)
	public ModelAndView searchEmployee(HttpServletRequest req) {
		String empIdVal=req.getParameter("empId");
		ModelAndView modelAndView=new ModelAndView();
//		modelAndView.setViewName("/WEB-INF/views/searchEmployee.jsp");
		modelAndView.setViewName("searchEmployee");
		req.setAttribute("empId", empIdVal);
		return modelAndView;
	}//............
	
	
	@RequestMapping(path ="/loginForm",method = RequestMethod.GET)
	public ModelAndView displayLoginForm(ModelAndView modelAndView) {
//		ModelAndView modelAndView=new ModelAndView();
//		modelAndView.setViewName("/WEB-INF/views/loginForm.jsp");
		modelAndView.setViewName("loginForm");
		return modelAndView;
	}//end of displayLoginForm()
	
	@RequestMapping(path ="/login1",method = RequestMethod.POST)
	public ModelAndView login1(HttpServletRequest req,ModelAndView modelAndView) {
		String empIdVal=req.getParameter("empId");
		int empId =Integer.parseInt(empIdVal);
		String password=req.getParameter("password");
		
		modelAndView.addObject("empId", empId);
		modelAndView.addObject("pwd", password);
//		modelAndView.setViewName("/WEB-INF/views/userDetails.jsp");
		modelAndView.setViewName("userDetails");
		return modelAndView;
		
	}// end of login1()........
	
	@PostMapping("/login2")
	public ModelAndView login2(@RequestParam(name="empId") int empId, 
			@RequestParam(name="password") String password, ModelAndView modelAndView) {
		modelAndView.addObject("empId", empId);
		modelAndView.addObject("password", password);
//		modelAndView.setViewName("/WEB-INF/views/userDetails.jsp");
		modelAndView.setViewName("userDetails");
		return modelAndView;	
	}//.....................
	
	@PostMapping("/login3")
	public String login3(int empId,String password, ModelMap modelMap) {
		modelMap.addAttribute("empId", empId);
		modelMap.addAttribute("password", password);
//		return"/WEB-INF/views/userDetails.jsp";
		return "userDetails";
	}
	
	@PostMapping("/login4")
	public String login4(UserBean userBean,String name,ModelMap modelMap) {
		modelMap.addAttribute("userBean", userBean);
		modelMap.addAttribute("name",name);
//		return"/WEB-INF/views/userDetails2.jsp";// when resource view resource is not used
	return "userDetails2";
	
	}
	
	
	
}// end of class
