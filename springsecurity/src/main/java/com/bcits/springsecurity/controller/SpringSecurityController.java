package com.bcits.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SpringSecurityController {
@GetMapping("/index")
public String getIndexPage() {
	return"index";
}
@GetMapping("/adminSecureHome")
public String getAdminPage() {
	return"adminHome";
}

@GetMapping("/userSecureHome")
public String getUserPage() {
	return"userHome";
}
@GetMapping("/login")
public String getloginPage() {
	return"loginForm";
}

}//End of Controller
