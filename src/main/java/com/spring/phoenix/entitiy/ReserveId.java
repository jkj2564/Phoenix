package com.spring.phoenix.entitiy;

import java.io.Serializable;

import lombok.Data;

@Data
public class ReserveId implements Serializable {
	private int reserve;
	
	private int TouristIdx;
}
