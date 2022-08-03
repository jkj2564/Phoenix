package com.spring.phoenix.service.tour.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.phoenix.entitiy.Reserve;
import com.spring.phoenix.entitiy.ReserveTourist;
import com.spring.phoenix.entitiy.Tour;
import com.spring.phoenix.entitiy.TourFile;
import com.spring.phoenix.repository.ReserveRepository;
import com.spring.phoenix.repository.ReserveTouristRopository;
import com.spring.phoenix.repository.TourFileRepository;
import com.spring.phoenix.repository.TourRepository;
import com.spring.phoenix.service.tour.TourService;

@Service
public class TourServiceImpl implements TourService {
	@Autowired
	TourRepository tourRepository;
	
	@Autowired
	TourFileRepository tourFileRepository;
	
	@Autowired
	ReserveRepository reserveRepository;
	
	@Autowired
	ReserveTouristRopository reserveTouristRepository;
	
	@Override
	public int insertTour(Tour tour) {
		tourRepository.save(tour);
		tourRepository.flush();
		return tour.getTourSeq();
	}
	
	@Override
	public List<Tour> tourInfo() {
		return tourRepository.findAll();
	}
	
	@Override
	public List<TourFile> tourInfoFile() {
		return tourFileRepository.findAll();
	}
	
	@Override
	public void insertTourFileList(List<TourFile> fileList) {
		for(TourFile tourFile : fileList) {
			tourFile.setFileSeq(tourFileRepository.selectNextFileSeqByBoardBoardSeq(tourFile.getTour().getTourSeq()));
			tourFileRepository.save(tourFile);
		}
	}
	
	@Override
	public Tour tourDeatil(int tourSeq) {
		return tourRepository.findById(tourSeq).get();
	}
	
	
	@Override
	public List<TourFile> tourDatilFile(int tourSeq) {
		List<TourFile> fileList = tourFileRepository.findByTourTourSeq(tourSeq);
		
		if(fileList == null || fileList.isEmpty()) {
			return null;
		} else {
			return fileList;
		}
	}

	@Override
	public void insertReservation(Reserve reserve) {
		reserveRepository.save(reserve);
	}
	
	@Override
	public void insertTourist(List<ReserveTourist> list) {
		for(ReserveTourist reserveTourist : list) {
			reserveTourist.setTouristSeq(reserveTouristRepository.selectNextFileSeqByReserveReserveSeq(reserveTourist.getReserve().getReserveSeq()));
			reserveTouristRepository.save(reserveTourist);
		}
	}
	
}
