package com.blood.bank.service_user.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blood.bank.service_user.Domain.User;

import jakarta.transaction.Transactional;

@Transactional
public interface UserRepo extends JpaRepository<User, Long> {

	Optional<User> findByUsername(String username);

	void deleteByUsername(String username);

}
