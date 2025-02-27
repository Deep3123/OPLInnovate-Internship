package com.sms.management.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sms.management.domain.Branch;

@Repository
public interface BranchRepo extends JpaRepository<Branch, Long> {

}
