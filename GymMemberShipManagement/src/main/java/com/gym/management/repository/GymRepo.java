package com.gym.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gym.management.domain.GymEntity;

public interface GymRepo extends JpaRepository<GymEntity, Long> {

}
