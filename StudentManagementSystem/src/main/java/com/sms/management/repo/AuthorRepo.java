package com.sms.management.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sms.management.domain.Author;

public interface AuthorRepo extends JpaRepository<Author, Long>{

}
