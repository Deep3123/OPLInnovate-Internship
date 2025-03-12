package com.blood.bank.service_bb.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blood.bank.service_bb.domain.BloodGroupAvailbilityStatus;

import jakarta.transaction.Transactional;

@Transactional
public interface BloodGroupAvailbilityStatusRepository extends JpaRepository<BloodGroupAvailbilityStatus, Long> {

	Optional<BloodGroupAvailbilityStatus> findByBloodGroupName(String bloodGroupName);

}
