package com.blood.bank.service_admin.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blood.bank.service_admin.domain.AdminEntity;

import jakarta.transaction.Transactional;

@Transactional
public interface AdminRepo extends JpaRepository<AdminEntity, Long> {

	Optional<AdminEntity> findByUsername(String username);

}
