package com.spring.phoenix.entitiy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="T_PH_USER")
@Data
public class User {
	@Id
	private String userId;
	
	@Column(nullable = false)
	private String userPw;
	
	@Column(nullable = false)
	private String userNm;

	private String userMail;

	private String userTel;

	private String userBirth;

	private String userGender;
	
	private String need1;
	
	private String need2;
	
	private String need3;
}
