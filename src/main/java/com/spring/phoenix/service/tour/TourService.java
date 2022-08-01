package com.spring.phoenix.service.tour;

import java.util.List;

import com.spring.phoenix.entitiy.Tour;
import com.spring.phoenix.entitiy.TourFile;


public interface TourService {
	int insertTour(Tour tour);
	
	List<Tour> tourInfo();
	
	List<TourFile> tourInfoFile();
	
	void insertTourFileList(List<TourFile> fileList);
	
	Tour tourDeatil(int tourSeq);
	
	List<TourFile> tourDatilFile(int tourSeq);
	
}
