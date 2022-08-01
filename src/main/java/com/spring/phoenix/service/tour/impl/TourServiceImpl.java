package com.spring.phoenix.service.tour.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.phoenix.entitiy.Tour;
import com.spring.phoenix.repository.TourRepository;
import com.spring.phoenix.service.tour.TourService;

@Service
public class TourServiceImpl implements TourService {
	@Autowired
	TourRepository tourRepository;
	
	@Override
	public int insertTour(Tour tour) {
		tourRepository.save(tour);
		tourRepository.flush();
		return tour.getTourSeq();
	}
}
