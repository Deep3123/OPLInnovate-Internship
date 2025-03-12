package com.ems.security.exception;

import java.util.HashMap;
import java.util.Map;

import javax.naming.AuthenticationException;

import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestControllerAdvice
public class GlobalException {

	@ExceptionHandler(value = AuthenticationException.class)
	public Map<String, Object> handleAuthenticationException(HttpServletRequest req, HttpServletResponse res,
			AuthenticationException e) {
		Map<String, Object> map = new HashMap<>();
		map.put("Error-Message: ", e.getMessage());
		map.put("Error-Path: ", req.getServletPath());
		map.put("Error-Class: ", e.getClass());
		map.put("Error-Status_code: ", res.getStatus());
		return map;
	}

	@ExceptionHandler(value = MalformedJwtException.class)
	public Map<String, Object> exception(HttpServletRequest req, HttpServletResponse res, MalformedJwtException e) {
		Map<String, Object> map = new HashMap<>();
		map.put("Error-Message: ", e.getMessage());
		map.put("Error-Path: ", req.getServletPath());
		map.put("Error-Class: ", e.getClass());
		map.put("Error-Status_code: ", res.getStatus());
		return map;
	}

	@ExceptionHandler(value = ExpiredJwtException.class)
	public Map<String, Object> exception(HttpServletRequest req, HttpServletResponse res, ExpiredJwtException e) {
		Map<String, Object> map = new HashMap<>();
		map.put("Error-Message: ", e.getMessage());
		map.put("Error-Path: ", req.getServletPath());
		map.put("Error-Class: ", e.getClass());
		map.put("Error-Status_code: ", res.getStatus());
		return map;
	}

	@ExceptionHandler(value = InsufficientAuthenticationException.class)
	public Map<String, Object> exception(HttpServletRequest req, HttpServletResponse res,
			InsufficientAuthenticationException e) {
		Map<String, Object> map = new HashMap<>();
		map.put("Error-Message: ", e.getMessage());
		map.put("Error-Path: ", req.getServletPath());
		map.put("Error-Class: ", e.getClass());
		map.put("Error-Status_code: ", res.getStatus());
		return map;
	}

	@ExceptionHandler(value = RuntimeException.class)
	public Map<String, Object> exception(HttpServletRequest req, HttpServletResponse res, RuntimeException e) {
		Map<String, Object> map = new HashMap<>();
		map.put("Error-Message: ", e.getMessage());
		map.put("Error-Path: ", req.getServletPath());
		map.put("Error-Class: ", e.getClass());
		map.put("Error-Status_code: ", res.getStatus());
		return map;
	}

	@ExceptionHandler(value = Exception.class)
	public Map<String, Object> exception(HttpServletRequest req, HttpServletResponse res, Exception e) {
		Map<String, Object> map = new HashMap<>();
		map.put("Error-Message: ", e.getMessage());
		map.put("Error-Path: ", req.getServletPath());
		map.put("Error-Class: ", e.getClass());
		map.put("Error-Status_code: ", res.getStatus());
		return map;
	}
}
