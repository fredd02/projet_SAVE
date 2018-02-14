package com.save.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.save.model.User;

public interface IUserRepository extends JpaRepository<User, Long>{
	
	User findByUsername(String username);

}
