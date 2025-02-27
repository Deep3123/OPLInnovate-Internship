package com.sms.management.service;

import java.util.List;
import com.sms.management.proxy.AuthorProxy;

public interface AuthorServices {
	public List<AuthorProxy> getAllAuthorDetails();

	public String saveAuthorDetails(AuthorProxy authorProxy);

	public String updateAuthorDetails(Long id, AuthorProxy authorProxy);

	public String deleteAuthorDetails(Long id);
}
