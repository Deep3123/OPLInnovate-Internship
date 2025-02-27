package com.sms.management.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sms.management.domain.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {

}
