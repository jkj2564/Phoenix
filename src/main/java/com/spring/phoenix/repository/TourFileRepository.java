package com.spring.phoenix.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.phoenix.entitiy.TourFile;
import com.spring.phoenix.entitiy.TourFileId;

public interface TourFileRepository extends JpaRepository<TourFile, TourFileId> {
	List<TourFile> findByTourTourSeq(int tour);
}
