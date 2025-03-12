package com.blood.bank.service_bb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blood.bank.service_bb.domain.BloodBank;

import jakarta.transaction.Transactional;

@Transactional
public interface BloodBankRepository extends JpaRepository<BloodBank, Long>{

}
