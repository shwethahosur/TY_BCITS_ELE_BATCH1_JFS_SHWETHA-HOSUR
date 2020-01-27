package com.bcits.springmvc1.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cookie")
public class CookieController {
	@GetMapping("/cookiePage")
	public String getCookiePage() {
		return "cookiePage";
	}
	@GetMapping("/createCookie")
public String creatyeCookie(HttpServletResponse resp,ModelMap modelMap)	{
	Cookie myCookie =new Cookie("empname","vidya");
	resp.addCookie(myCookie);
	modelMap.addAttribute("msg", "cookie created successfully");
	return "cookiePage";
}
@GetMapping("/readCookie")
public String readCookie(@CookieValue(name="empname" ,required=false)String employeename,ModelMap map) {
	if(employeename!=null) {
		map.addAttribute("msg", "cookie value is: "+employeename);
	}else {
		map.addAttribute("errmsg", "cookie is not presnt");
	}

return "cookiePage";
	
}
}
