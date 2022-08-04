package com.spring.phoenix.controller.tour;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.phoenix.commons.FileUtils;
import com.spring.phoenix.entitiy.Reserve;
import com.spring.phoenix.entitiy.ReserveTourist;
import com.spring.phoenix.entitiy.Tour;
import com.spring.phoenix.entitiy.TourFile;
import com.spring.phoenix.service.tour.TourService;

@RestController
@RequestMapping("/tour")
public class TourController {
	@Autowired
	TourService tourService;

	@GetMapping("/tourInfo")
	public ModelAndView tourInfoView(Tour tour) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("tour/tourInfo.html");
		
//		if(tour.getSearchCondition() != null && !tour.getSearchCondition().equals("")) {
//			mv.addObject("searchCondition", tour.getSearchCondition());
//		}
//		
//		if(tour.getSearchKeyword() != null && !tour.getSearchKeyword().equals("")) {
//			mv.addObject("searchKeyword", tour.getSearchKeyword());
//		}
		
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
	public void insertTour(HttpServletResponse response, Tour tour, HttpServletRequest request,
			MultipartHttpServletRequest multipartServletRequest) throws IOException {
		int tourSeq = tourService.insertTour(tour);

		FileUtils fileUtils = new FileUtils();
		List<TourFile> fileList = fileUtils.parseFileInfo(tourSeq, request, multipartServletRequest);

		tourService.insertTourFileList(fileList);

		response.sendRedirect("/tour/tourInfo");
	}

	@GetMapping("/reservation")
	public ModelAndView reservationView(Reserve reserve) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/tour/tourReservation.html");

		mv.addObject("reserve", reserve);

		return mv;
	}

	@PostMapping("/reservation")
	public void reservation(@RequestParam Map<String, String> paramMap)
			throws JsonMappingException, JsonProcessingException, IOException {	
		
		Reserve reserve = new Reserve();
		Tour tour = new Tour();
		tour.setTourSeq(Integer.parseInt(paramMap.get("tourSeq")));
		reserve.setTour(tour);
		reserve.setStartDate(paramMap.get("startDate"));
		reserve.setEndDate(paramMap.get("endDate"));
		reserve.setRUserName(paramMap.get("rUserName"));
		reserve.setRUserEmail(paramMap.get("rUserEmail"));
		reserve.setRUserBirth(paramMap.get("rUserBirth"));
		reserve.setRUserTel(paramMap.get("rUserTel"));
		reserve.setRAdult(Integer.parseInt(paramMap.get("rAdult")));
		reserve.setRChild(Integer.parseInt(paramMap.get("rChild")));
		reserve.setRBaby(Integer.parseInt(paramMap.get("rBaby")));
		reserve.setRPrice(Integer.parseInt(paramMap.get("rPrice")));
		
		tourService.insertReservation(reserve);

		List<ReserveTourist> tourList = new ArrayList<ReserveTourist>();
		String str = paramMap.get("list");
		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		ObjectMapper mapper = new ObjectMapper();
		list = mapper.readValue(str, ArrayList.class);

		for (int i = 0; i < list.size(); i++) {
			ReserveTourist tourist = new ReserveTourist();
			tourist.setReserve(reserve);
			tourist.setTName((String) list.get(i).get("name"));
			tourist.setTBirth((String) list.get(i).get("birth"));
			tourist.setTGender((String) list.get(i).get("gender"));
			tourist.setTEmail((String) list.get(i).get("email"));
			tourist.setTTel((String) list.get(i).get("tel"));
			tourist.setAge((String) list.get(i).get("age"));
			tourList.add(tourist);
		}

		tourService.insertTourist(tourList);

	}
}
