package com.spring.phoenix.entitiy;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="T_PH_RESERVE")
@Data
@SequenceGenerator(name="T_PH_RESERVE_SEQ_GENERATOR",
					sequenceName="T_PH_RESERVE_SEQ",
					initialValue=1,
					allocationSize=1)
public class Reserve {
	@ManyToOne
	@JoinColumn(name="TOUR_SEQ")
	private Tour tour;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "T_PH_RESERVE_SEQ_GENERATOR" )
	private int reserveSeq;
	
//	@Column(nullable = false)
	private String startDate;
	
//	@Column(nullable = false)
	private String endDate;
	

	private String rUserName;
	

	private String rUserEmail;
	

	private String rUserBirth;
	

	private String rUserTel;
	
//	@Column(nullable = false)
	private int rAdult;
	
//	@Column(nullable = false)
	private int rChild;
	
//	@Column(nullable = false)
	private int rBaby;
	
//	@Column(nullable = false)
	private int rPrice;
	
	private LocalDateTime boardRegDate = LocalDateTime.now();
	
	private LocalDateTime boardMdfDate = LocalDateTime.now();
	
}
