package com.spring.phoenix.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.spring.phoenix.entitiy.ReserveId;
import com.spring.phoenix.entitiy.ReserveTourist;

public interface ReserveTouristRopository extends JpaRepository<ReserveTourist, ReserveId> {
	@Query(value="select ifnull(max(t.tourist_Seq), 0) + 1 from t_ph_reserve_tourist t where t.reserve_Seq = :reserveSeq", nativeQuery=true)
	int selectNextFileSeqByReserveReserveSeq(@Param("reserveSeq") int reserveSeq);
}
