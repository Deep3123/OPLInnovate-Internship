package com.sms.management.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.management.domain.Author;
import com.sms.management.global.exception.ListEmptyException;
import com.sms.management.global.exception.MissingId;
import com.sms.management.proxy.AuthorProxy;
import com.sms.management.repo.AuthorRepo;
import com.sms.management.service.AuthorServices;
import com.sms.management.util.MapperUtils;

@Service
public class AuthorSeriveImpl implements AuthorServices {
	@Autowired
	private AuthorRepo authorRepo;

	@Autowired
	private MapperUtils mapperUtils;

	@Override
	public List<AuthorProxy> getAllAuthorDetails() {
		// TODO Auto-generated method stub
		if (!authorRepo.findAll().isEmpty()) {
			List<Author> authors = authorRepo.findAll();

			authors.stream().forEach(obj -> obj.getBooks().stream().forEach(obj2 -> obj2.setAuthors(null)));

			return mapperUtils.ListofAuthorEntitytoAuthorProxy(authors);
		} else {
			throw new ListEmptyException("No data to display currently!!!", 404);
		}
	}

	@Override
	public String saveAuthorDetails(AuthorProxy authorProxy) {
		// TODO Auto-generated method stub
		authorRepo.save(mapperUtils.AuthorProxytoAuthorEntity(authorProxy));
		return "Data of authors saved successfully.";
	}

	@Override
	public String updateAuthorDetails(Long id, AuthorProxy authorProxy) {
		// TODO Auto-generated method stub
		Optional<Author> auth = authorRepo.findById(id);

		if (auth.isPresent()) {
			Author author = auth.get();

			if (authorProxy.getAuthorId() != null)
				author.setAuthorId(authorProxy.getAuthorId());

			if (authorProxy.getAuthorName() != null)
				author.setAuthorName(authorProxy.getAuthorName());

			if (authorProxy.getBooks() != null)
				author.setBooks(mapperUtils.ListofBooksProxytoBooksEntity(authorProxy.getBooks()));

			authorRepo.save(author);

			return "Data of authors updated successfully.";
		} else {
			throw new MissingId("Either id is missing in database or id is invalid.", 400);
		}
	}

	@Override
	public String deleteAuthorDetails(Long id) {
		// TODO Auto-generated method stub
		if (id != null && authorRepo.findById(id).isPresent()) {
			authorRepo.deleteById(id);
			return "Data of branch deleted successfully.";
		} else {
			throw new MissingId("Id missing in database or invalid id.", 400);
		}
	}

}
