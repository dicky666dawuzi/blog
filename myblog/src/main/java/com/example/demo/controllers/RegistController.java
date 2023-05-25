package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.services.UserService;

@Controller
public class RegistController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/regist")
	public String getRegist() {
		return "regist.html";
	}
	
	@PostMapping("/user-regist")
	public ModelAndView userRegist(@RequestParam String username, @RequestParam String password,
									@RequestParam String email, @RequestParam String rpassword, ModelAndView mav) {
		if (userService.isUsernameExist(username)) {
			mav.addObject("flag", 2);
		}else if(!password.equals(rpassword)){
			mav.addObject("flag", 4);
		}else {			
			userService.createNewUser(username, password, email);
			mav.addObject("flag", 3);
		}
		mav.setViewName("register.html");
		return mav;
		
//		if (username.equals("admin") && password.equals("123456")) {
//			mav.addObject("name", username);
//			mav.setViewName("hello.html");
//			return mav;			
//		} else {
//			mav.addObject("flag", 1);
//			mav.setViewName("login.html");
//			return mav;
//		}
	}
}

