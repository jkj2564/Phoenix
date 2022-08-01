package com.spring.phoenix.service.tour;

import java.util.List;

import com.spring.phoenix.entitiy.Tour;


public interface TourService {
	int insertTour(Tour tour);
	
	List<Tour> tourInfo();
}
