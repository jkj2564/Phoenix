package com.spring.phoenix.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.phoenix.entitiy.Tour;

public interface TourRepository extends JpaRepository<Tour, Integer> {

}
