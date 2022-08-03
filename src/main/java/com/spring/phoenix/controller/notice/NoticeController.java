package com.spring.phoenix.controller.notice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/notice")
public class NoticeController {
	@GetMapping("/notice")
	public ModelAndView eventView() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("notice/notice.html"); 
		
		return mv;
	}
}
