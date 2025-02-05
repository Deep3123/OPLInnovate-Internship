package com.car.management.exception.globalexception;

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
	public ErrorResponse methodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
		return new ErrorResponse("Type mismatch in id parameter, Id is not in Integer format.", 404);
	}

	@ExceptionHandler(value = NoResourceFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public ErrorResponse noResourceFoundException(NoResourceFoundException e) {
		return new ErrorResponse("URL format is not matching, may be some parameters are null or empty.", 404);
	}
}