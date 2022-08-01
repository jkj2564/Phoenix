package com.spring.phoenix.entitiy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="T_USER")
@Data
public class User {
	@Id
	private String userId;
	@Column(nullable = false)
	private String userPw;
	@Column(nullable = false)
	private String userNm;
	@Column(nullable = false)
	private String userMail;
	@Column(nullable = false)
	private String userTel;
	@Column(nullable = false)
	private String userBirth;
	@Column(nullable = false)
	private String userGender;
	private String need1;
	private String need2;
	private String need3;
}
