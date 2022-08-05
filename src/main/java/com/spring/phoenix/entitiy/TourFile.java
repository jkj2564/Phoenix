package com.spring.phoenix.entitiy;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="T_PH_TOUR_FILE")
@Data
@IdClass(TourFileId.class)
public class TourFile {
	@Id
	@ManyToOne
	@JoinColumn(name="TOUR_SEQ")
	private Tour tour;
	
	@Id
	private int fileSeq;
	
	private String originalFileName;
	
	private String fileName;
	
	private String filePath;
}
