package com.spring.phoenix.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.phoenix.entitiy.User;

public interface UserRepository extends JpaRepository<User, String>{
										//user라는 entity를 사용하고 아이디로는 string을 쓸거다.
	User findByUserId(String UserId);
	
	
}

