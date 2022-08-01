package com.spring.phoenix.controller.tour;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.spring.phoenix.entitiy.Tour;
import com.spring.phoenix.service.tour.TourService;

@RestController
@RequestMapping("/tour")
public class TourController {
	@Autowired
	TourService tourService;
	
	@GetMapping("tourInfo")
	public ModelAndView tourInfoView() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("tour/tourInfo.html");
		
		return mv;
	}
	
	
	@GetMapping("/tourDetail")
	public ModelAndView tourDetail() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/tour/tourDetail.html");
		
		return mv;
	}
	
	@GetMapping("/insertTour")
	public ModelAndView insertTourView() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/tour/insertTour.html");
		
		return mv;
	}
	
	@PostMapping("/insertTour")
	public void insertTour(HttpServletResponse response, Tour tour, HttpServletRequest request, MultipartHttpServletRequest multipartServletRequest) throws IOException {
		int tourSeq = tourService.insertTour(tour);
		
		response.sendRedirect("/tour/tourInfo");
	}
}
