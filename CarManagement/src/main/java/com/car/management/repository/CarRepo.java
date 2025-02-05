package com.car.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.car.management.domain.CarEntity;

@Repository
public interface CarRepo extends JpaRepository<CarEntity, Long> {

}
