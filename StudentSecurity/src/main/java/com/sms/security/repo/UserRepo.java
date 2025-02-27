package com.sms.security.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sms.security.domain.User;

public interface UserRepo extends JpaRepository<User, Long> {
	public User findByUsername(String username);
}
