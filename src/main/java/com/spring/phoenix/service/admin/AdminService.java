package com.spring.phoenix.service.admin;

import java.util.List;

import com.spring.phoenix.entitiy.Reserve;
import com.spring.phoenix.entitiy.Tour;

public interface AdminService {
	List<Tour> tourList();
	
	List<Reserve> tourReservationList();
	
	void deleteReservaiton(int reserveSeq);
}
