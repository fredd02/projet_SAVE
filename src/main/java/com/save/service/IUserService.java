package com.save.service;

import com.save.model.User;

public interface IUserService {
	
	void save(User user);
	
	User findByUsername(String username);

}
