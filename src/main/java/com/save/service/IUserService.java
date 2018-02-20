package com.save.service;

import java.util.Optional;

import com.save.model.User;

public interface IUserService {
	
	public void save(User user);
	
	public User findByUsername(String username);
	
	public Optional<User> findUserByEmail(String email);
	
	public Optional<User> findUserByResetToken(String resetToken);

}
