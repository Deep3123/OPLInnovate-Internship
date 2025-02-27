package com.ems.security.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ems.security.domain.Admin;

public interface AdminRepo extends JpaRepository<Admin, Long> {

}
