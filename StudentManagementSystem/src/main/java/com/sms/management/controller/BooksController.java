package com.sms.management.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sms.management.proxy.BooksProxy;
import com.sms.management.service.BooksServices;

@RestController
@RequestMapping("/books")
public class BooksController {
	@Autowired
	private BooksServices booksServices;

	@PostMapping("/getAllBooksDetails")
	public List<BooksProxy> getAllBooksDetails() {
		return booksServices.getAllBooksDetails();
	}

	@PostMapping("/saveBooksDetails")
	public String saveBooksDetails(@RequestBody BooksProxy booksProxy) {
		return booksServices.saveBooksDetails(booksProxy);
	}

	@PostMapping("/updateBooksDetails/{id}")
	public String updateBooksDetails(@PathVariable("id") Long id, @RequestBody BooksProxy booksProxy) {
		return booksServices.updateBooksDetails(id, booksProxy);
	}

	@PostMapping("/deleteBooksDetails/{id}")
	public String deleteBooksDetails(@PathVariable("id") Long id) {
		return booksServices.deleteBooksDetails(id);
	}
}
