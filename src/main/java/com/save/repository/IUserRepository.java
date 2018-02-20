package com.save.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.save.model.User;

public interface IUserRepository extends JpaRepository<User, Long>{
	
	User findByUsername(String username);
	Optional<User> findByEmail(String email);
	Optional<User> findByResetToken(String resetToken);

}
