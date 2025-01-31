package com.main.viewproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ViewController {
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String getIndexPage() {
		return "Index";
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String getHomePage() {
		return "Home";
	}

	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public String getContactPage() {
		return "Contact";
	}
}