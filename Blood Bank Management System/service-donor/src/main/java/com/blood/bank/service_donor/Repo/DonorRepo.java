package com.blood.bank.service_donor.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blood.bank.service_donor.Domain.Donor;

import jakarta.transaction.Transactional;

@Transactional
public interface DonorRepo extends JpaRepository<Donor, Long> {

	void deleteByUsername(String username);

	Optional<Donor> findByUsername(String donorname);

}
