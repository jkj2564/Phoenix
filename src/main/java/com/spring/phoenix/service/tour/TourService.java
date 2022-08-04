package com.spring.phoenix.service.tour;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.spring.phoenix.entitiy.Reserve;
import com.spring.phoenix.entitiy.ReserveTourist;
import com.spring.phoenix.entitiy.Tour;
import com.spring.phoenix.entitiy.TourFile;


public interface TourService {
	int insertTour(Tour tour);
	
	List<Tour> tourInfo();
	
	List<TourFile> tourInfoFile();
	
	void insertTourFileList(List<TourFile> fileList);
	
	Tour tourDeatil(int tourSeq);
	
	List<TourFile> tourDatilFile(int tourSeq);
	
	void insertReservation(Reserve reserve);
	
	void insertTourist(List<ReserveTourist> list);
	
	List<Tour> tourList();
	
	void deleteTour(int tourSeq);
	
	List<Reserve> tourReservationList();
		
}
