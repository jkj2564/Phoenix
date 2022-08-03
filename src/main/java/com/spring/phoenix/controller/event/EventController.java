package com.spring.phoenix.controller.event;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/event")
public class EventController {
	@GetMapping("/event")
	public ModelAndView eventView() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("event/event.html");
		
		return mv;
	}
}
