package com.spring.phoenix.entitiy;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="T_PH_TOUR")
@Data
@SequenceGenerator(name="T_TOUR_SEQ_GENERATOR",
					sequenceName="T_TOUR_SEQ",
					initialValue=1,
					allocationSize=1)
public class Tour {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "T_TOUR_SEQ_GENERATOR")
	private int tourSeq;
	
	@Column(nullable = false)
	private String tourPackage;
	
	@Column(nullable = false)
	private String tourTitle;
	
	@Column(nullable = false)
	private String tourContent;
	
	@Column(nullable = false)
	private int tourNight;
	
	@Column(nullable = false)
	private int tourDay;
	
	@Column(nullable = false)
	private String tourPriceAdult;
	
	@Column(nullable = false)
	private String tourPriceChild;
	
	@Column(nullable = false)
	private String tourPriceBaby;
	
	private String tourInfo;
	
	private String tourPlan;
	
	private String tourDestination;
	
	private String tourHotel;
	
	private String tourNotice;
	
	private LocalDateTime boardRegDate = LocalDateTime.now();
	
	private LocalDateTime boardMdfDate = LocalDateTime.now();
}
