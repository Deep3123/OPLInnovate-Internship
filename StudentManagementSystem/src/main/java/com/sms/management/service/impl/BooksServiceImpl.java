package com.sms.management.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.management.domain.Author;
import com.sms.management.domain.Books;
import com.sms.management.global.exception.ListEmptyException;
import com.sms.management.global.exception.MissingId;
import com.sms.management.proxy.AuthorProxy;
import com.sms.management.proxy.BooksProxy;
import com.sms.management.repo.BooksRepo;
import com.sms.management.service.BooksServices;
import com.sms.management.util.MapperUtils;

@Service
public class BooksServiceImpl implements BooksServices {

	@Autowired
	private BooksRepo booksRepo;

	@Autowired
	private MapperUtils mapperUtils;

	@Override
	public List<BooksProxy> getAllBooksDetails() {
		// TODO Auto-generated method stub
		if (!booksRepo.findAll().isEmpty()) {
			List<Books> books = booksRepo.findAll();

			books.stream().forEach(obj -> obj.getAuthors().stream().forEach(obj2 -> obj2.setBooks(null)));

			return mapperUtils.ListofBooksEntitytoBooksProxy(books);
		} else {
			throw new ListEmptyException("No data to display currently!!!", 404);
		}
	}

	@Override
	public String saveBooksDetails(BooksProxy booksProxy) {
		// TODO Auto-generated method stub
		List<AuthorProxy> authorProxies = booksProxy.getAuthors();
		booksProxy.setAuthors(authorProxies);
		booksRepo.save(mapperUtils.BooksProxytoBooksEntity(booksProxy));
		return "Data of books saved successfully.";
	}

	@Override
	public String updateBooksDetails(Long id, BooksProxy booksProxy) {
		// TODO Auto-generated method stub
		Optional<Books> book = booksRepo.findById(id);

		if (book.isPresent()) {
			Books books = book.get();

			if (booksProxy.getBookId() != null)
				books.setBookId(booksProxy.getBookId());

			if (booksProxy.getBookSsnNo() != null)
				books.setBookSsnNo(booksProxy.getBookSsnNo());

			if (booksProxy.getAuthors() != null)
				books.setAuthors(mapperUtils.ListofAuthorProxytoAuthorEntity(booksProxy.getAuthors()));

			booksRepo.save(books);

			return "Data of books updated successfully.";
		} else {
			throw new MissingId("Either id is missing in database or id is invalid.", 400);
		}
	}

	@Override
	public String deleteBooksDetails(Long id) {
		// TODO Auto-generated method stub
		if (id != null && booksRepo.findById(id).isPresent()) {
			booksRepo.deleteById(id);
			return "Data of branch deleted successfully.";
		} else {
			throw new MissingId("Id missing in database or invalid id.", 400);
		}
	}

}
