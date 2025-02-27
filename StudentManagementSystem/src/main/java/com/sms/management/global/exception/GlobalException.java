package com.sms.management.global.exception;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@RestControllerAdvice
public class GlobalException {

	@ExceptionHandler(value = InternalServerError.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorResponse internalServerError(InternalServerError e) {
		return new ErrorResponse("Something went wrong !!!, Please try again !!!", 500);
	}

	@ExceptionHandler(value = MissingId.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ErrorResponse missingId(MissingId e) {
		return new ErrorResponse(e.getError_name(), e.getError_code());
	}

	@ExceptionHandler(value = NoSuchElementException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public ErrorResponse noSuchElement(NoSuchElementException e) {
		return new ErrorResponse(e.getMessage(), 404);
	}

	@ExceptionHandler(value = ListEmptyException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public ErrorResponse listElementException(ListEmptyException e) {
		return new ErrorResponse(e.getError_name(), e.getError_code());
	}

	@ExceptionHandler(value = HttpMessageNotReadableException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ErrorResponse dataNotFound(HttpMessageNotReadableException e) {
		return new ErrorResponse("Some data is missing or Type mismatch occur in any one or more fields.", 400);
	}

	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public Map<String, String> methodArgumentNotValidException(MethodArgumentNotValidException e) {
		Map<String, String> err = new HashMap<>();

		e.getAllErrors().forEach(obj -> err.put(((FieldError) obj).getField(), obj.getDefaultMessage()));

		return err;
	}

	@ExceptionHandler(value = MethodArgumentTypeMismatchException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public Map<String, String> methodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
		Map<String, String> err = new HashMap<>();

		err.put("message", "Invalid value for 'id'. Expected a valid Integer but got: " + e.getValue() + " value.");

		return err;
	}

	@ExceptionHandler(value = NoResourceFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public ErrorResponse noResourceFoundException(NoResourceFoundException e) {
		return new ErrorResponse("URL format is not matching, may be some parameters are null or empty.", 404);
	}
	
//	@ExceptionHandler(value = java.lang.IllegalArgumentException.class)
//	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
//	public ErrorResponse ArgumentException(java.lang.IllegalArgumentException ex) {
//		return new ErrorResponse(
//				"Enter only valid gender value.....[MALE, FEMALE, OTHER] (It is type sensitive field, so type in capital.)",
//				400);
//	}

//	@ExceptionHandler(value = org.springframework.dao.DataIntegrityViolationException.class)
//	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
//	public ErrorResponse ArgumentExceptiogn(org.springframework.dao.DataIntegrityViolationException ex) {
//		return new ErrorResponse("Could not Accept Duplicate entry", 410);
//	}

//	@ExceptionHandler(value = Exception.class)
//	@ResponseStatus(value = HttpStatus.SERVICE_UNAVAILABLE)
//	public ErrorResponse exception(Exception e) {
//		return new ErrorResponse("Something went wrong with our servers, we are working on it, we will be back soon!!!",
//				500);
//	}
}