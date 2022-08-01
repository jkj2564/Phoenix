package com.spring.phoenix.controller.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/user")
public class UserController {

	
	@GetMapping("/join")
	public ModelAndView joinView() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("user/join.html");
		
		return mv;
	}
	
	@GetMapping("/login")
	public ModelAndView loginView() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("user/login.html");
		
		return mv;
	}

}
