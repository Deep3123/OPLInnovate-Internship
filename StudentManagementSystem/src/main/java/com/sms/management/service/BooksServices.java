package com.sms.management.service;

import java.util.List;
import com.sms.management.proxy.BooksProxy;

public interface BooksServices {
	public List<BooksProxy> getAllBooksDetails();

	public String saveBooksDetails(BooksProxy booksProxy);

	public String updateBooksDetails(Long id, BooksProxy booksProxy);

	public String deleteBooksDetails(Long id);
}
