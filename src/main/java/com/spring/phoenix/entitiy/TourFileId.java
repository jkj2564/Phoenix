package com.spring.phoenix.entitiy;

import java.io.Serializable;

import lombok.Data;

@Data
public class TourFileId implements Serializable {
	private int tour;
	private int fileSeq;
}
