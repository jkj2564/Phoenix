package com.spring.phoenix.service.user;

import com.spring.phoenix.entitiy.User;

public interface UserService {

	void join(User user);
	
	User idCheck(String userId);

}
