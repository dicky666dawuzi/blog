package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.models.User;
import com.example.demo.services.UserService;

@Controller
public class LoginController {
	@Autowired
	private UserService userService;
	private int i = 3;
	
	@GetMapping("/login")
	public String getLogin() {
		return "login.html";
	}
	
	@PostMapping("/user-login")
	public ModelAndView userLogin(@RequestParam String username, @RequestParam String password, ModelAndView mav) {
		if (userService.isAccountinfoCorrect(username, password)) {
			mav.addObject("name", username);
			mav.setViewName("blog.html");
			i = 3;
		} else if(i > 0) {
			i--;
			mav.addObject("flag", 1);
			mav.addObject("i", i);
			mav.setViewName("login.html");
		}else {
			mav.addObject("flag", 2);
			mav.setViewName("forbid.html");			
		}
		return mav;
		
//		List<Account> accounts = accountRepository.findAll();
//		boolean flag = true;
//		if (accounts != null) {
//			for (Account account : accounts) {
//				if(account.getUsername().equals(username) && account.getPassword().equals(password)) {
//					mav.addObject("name", username);
//					mav.setViewName("hello.html");
//					flag = false;
//					break;
//				} 
//			}			
//			if (flag) {
//				mav.addObject("flag", 1);
//				mav.setViewName("login.html");					
//			}
//		}
//		return mav;
		
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
