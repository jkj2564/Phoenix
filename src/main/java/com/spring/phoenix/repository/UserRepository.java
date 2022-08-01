package com.spring.phoenix.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.phoenix.entitiy.User;

public interface UserRepository extends JpaRepository<User, String> {
	User findByUserId(String UserId);
}
