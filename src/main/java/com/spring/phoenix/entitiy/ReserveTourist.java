package com.spring.phoenix.entitiy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="T_PH_RESERVE_TOURIST")
@Data
@IdClass(ReserveId.class)
public class ReserveTourist {
	@Id
	@ManyToOne
	@JoinColumn(name="RESERVE_SEQ")
	private Reserve reserve;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int TouristIdx;
	
	@Column(nullable = false)
	private String age;
	
	@Column(nullable = false)
	private String tName;
	
	@Column(nullable = false)
	private String tBirth;
	
	@Column(nullable = false)
	private String tGender;
	
	private String tEmail;
	
	private String tTel;
}
