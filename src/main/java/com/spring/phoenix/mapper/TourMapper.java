package com.spring.phoenix.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.spring.phoenix.entitiy.Tour;

@Mapper
public interface TourMapper {
	@Select("SELECT * FROM T_PH_TOUR WHERE (TOUR_PACKAGE = '친구 패키지' OR TOUR_PACKAGE = '연인 패키지') AND TOUR_TITLE LIKE CONCAT('%', #{searchKeyword}, '%');")
	List<Tour> getTourP1(String searchKeyword);
	
	@Select("SELECT * FROM T_PH_TOUR WHERE (TOUR_PACKAGE = '가족(노인) 패키지' OR TOUR_PACKAGE = '가족(아이) 패키지') AND TOUR_TITLE LIKE CONCAT('%', #{searchKeyword}, '%');")
	List<Tour> getTourP2(String searchKeyword);
	
	@Select("SELECT * FROM T_PH_TOUR WHERE TOUR_PACKAGE = '애완동물 패키지' AND TOUR_TITLE LIKE CONCAT('%', #{searchKeyword}, '%');")
	List<Tour> getTourP3(String searchKeyword);
}
