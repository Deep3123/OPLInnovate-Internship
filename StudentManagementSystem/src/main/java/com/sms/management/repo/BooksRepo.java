package com.sms.management.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sms.management.domain.Books;

public interface BooksRepo extends JpaRepository<Books, Long> {

}
