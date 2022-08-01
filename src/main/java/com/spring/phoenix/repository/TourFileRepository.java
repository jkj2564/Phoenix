package com.spring.phoenix.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.spring.phoenix.entitiy.TourFile;
import com.spring.phoenix.entitiy.TourFileId;

public interface TourFileRepository extends JpaRepository<TourFile, TourFileId> {
	List<TourFile> findByTourTourSeq(int tour);
	
	@Query(value="select ifnull(max(f.file_seq), 0) + 1 from t_ph_tour_file f where f.tour_seq = :tourSeq", nativeQuery=true)
	int selectNextFileSeqByBoardBoardSeq(@Param("tourSeq") int tourSeq);
}
