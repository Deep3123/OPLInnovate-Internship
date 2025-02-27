package com.sms.management.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sms.management.domain.MobileNo;

public interface MobileNoRepo extends JpaRepository<MobileNo, Long> {

}
