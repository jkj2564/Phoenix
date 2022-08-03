package com.spring.phoenix.review;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/review")
public class ReviewController {
	@GetMapping("/review")
	public ModelAndView reviewView() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("review/review.html");
		
		return mv;
	}
}
