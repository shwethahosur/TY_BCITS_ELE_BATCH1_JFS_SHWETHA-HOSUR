package com.bcits.springmvc1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RequestDelegationController {
	@GetMapping("/redirect")
public String redirectRequest() {
	return "redirect:https://www.github.com";
}//
	@GetMapping("/forward")
	public String forwardRequest() {
		return "forward:loginForm";
	}//	
	
}
