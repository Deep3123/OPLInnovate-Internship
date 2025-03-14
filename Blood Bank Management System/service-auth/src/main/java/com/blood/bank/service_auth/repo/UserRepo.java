package com.blood.bank.service_auth.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blood.bank.service_auth.domain.User;

import jakarta.transaction.Transactional;

@Transactional
public interface UserRepo extends JpaRepository<User, Long> {
	public User findByUsernameAndPassword(String username, String password);

	public User findByUsername(String username);
}
