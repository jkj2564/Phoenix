package com.spring.phoenix.controller.tour;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.spring.phoenix.commons.FileUtils;
import com.spring.phoenix.entitiy.Tour;
import com.spring.phoenix.entitiy.TourFile;
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
		
		List<Tour> tourList = tourService.tourInfo();
		mv.addObject("tourList", tourList);
		
		List<TourFile> tourFileList = tourService.tourInfoFile();
		mv.addObject("tourFileList", tourFileList);
		
		return mv;
	}
	
	
	@GetMapping("/tourDetail/{tourSeq}")
	public ModelAndView tourDetail(@PathVariable int tourSeq) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/tour/tourDetail.html");
		
		Tour tour = tourService.tourDeatil(tourSeq);
		List<TourFile> fileList = tourService.tourDatilFile(tourSeq);
		
		mv.addObject("tour", tour);
		mv.addObject("fileList", fileList);
		
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
		
		FileUtils fileUtils = new FileUtils();
		List<TourFile> fileList = fileUtils.parseFileInfo(tourSeq, request, multipartServletRequest);
		
		tourService.insertTourFileList(fileList);
		
		response.sendRedirect("/tour/tourInfo");
	}
	
	@GetMapping("/reservation")
	public ModelAndView reservation() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/tour/tourReservation.html");
		
		return mv;
	}
}
