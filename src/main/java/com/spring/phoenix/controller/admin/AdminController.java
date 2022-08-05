package com.spring.phoenix.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.spring.phoenix.entitiy.Reserve;
import com.spring.phoenix.entitiy.Tour;
import com.spring.phoenix.service.admin.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	AdminService adminService;
	
	@GetMapping("/tourList")
	public ModelAndView tourList() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin/tourList.html");
		
		List<Tour> tourList = adminService.tourList();
		mv.addObject("tourList", tourList);
		return mv;
	}
		
	@GetMapping("/reservationList")
	public ModelAndView reservationList() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/admin/reservationList.html");
		
		List<Reserve> rList = adminService.tourReservationList();
		mv.addObject("rList", rList);
		return mv;
	}
	
	@GetMapping("/deleteReservation/{reserveSeq}")
	public void deleteReservation(@PathVariable int reserveSeq, HttpServletResponse response) throws IOException {
		adminService.deleteReservaiton(reserveSeq);
		
		response.sendRedirect("/admin/reservationList");
	}

}
