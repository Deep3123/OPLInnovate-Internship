package com.sms.management.proxy;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(Include.NON_EMPTY)
public class BooksProxy {
	@NotNull(message = "ID cannot be null or empty.")
	private Long bookId;

	@NotBlank(message = "SSN number book cannot be null or empty.")
	private String bookSsnNo;

	private List<AuthorProxy> authors;
}
