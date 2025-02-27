package com.sms.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sms.management.proxy.AuthorProxy;
import com.sms.management.service.AuthorServices;

@RestController
@RequestMapping("/author")
public class AuthorController {
	@Autowired
	private AuthorServices authorServices;

	@PostMapping("/getAllAuthorDetails")
	public List<AuthorProxy> getAllAuthorDetails() {
		return authorServices.getAllAuthorDetails();
	}

	@PostMapping("/saveAuthorDetails")
	public String saveAuthorDetails(@RequestBody AuthorProxy authorProxy) {
		return authorServices.saveAuthorDetails(authorProxy);
	}

	@PostMapping("/updateAuthorDetails/{id}")
	public String updateAuthorDetails(@PathVariable("id") Long id, @RequestBody AuthorProxy authorProxy) {
		return authorServices.updateAuthorDetails(id, authorProxy);
	}

	@PostMapping("/deleteAuthorDetails/{id}")
	public String deleteAuthorDetails(@PathVariable("id") Long id) {
		return authorServices.deleteAuthorDetails(id);
	}
}
