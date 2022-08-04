package com.spring.phoenix.service.admin.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.phoenix.entitiy.Reserve;
import com.spring.phoenix.entitiy.Tour;
import com.spring.phoenix.repository.ReserveRepository;
import com.spring.phoenix.repository.TourRepository;
import com.spring.phoenix.service.admin.AdminService;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	TourRepository tourRepository;
	
	@Autowired
	ReserveRepository reserveRepository;
	
	@Override
	public List<Tour> tourList() {
		return tourRepository.findAll();
	}
	
	@Override
	public void deleteTour(int tourSeq) {
		tourRepository.deleteById(tourSeq);
	}
	
	@Override
	public List<Reserve> tourReservationList() {
		return reserveRepository.findAll();
	}
	
	@Override
	public void deleteReservaiton(int reserveSeq) {
		reserveRepository.deleteById(reserveSeq);
	}
}
