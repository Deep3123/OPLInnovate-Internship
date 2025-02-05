package com.main.superhero.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.stereotype.Component;
import com.main.superhero.domain.SuperHero;

@Component
public class ValidateData {
	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
			Pattern.CASE_INSENSITIVE);

	Boolean validateId(Long id) {
		if (id == null) {
			return false;
		}
		return true;
	}

//	Boolean validateData(SuperHero s) {
//		Long id = s.getId();
//
//		if (id == null) {
//			return false;
//		}
//
//		String name = s.getName();
//
//		if (name == null || name.isEmpty()) {
//			return false;
//		}
//
//		String username = s.getUsername();
//
//		if (username == null || username.isEmpty() || username.length() < 5) {
//			return false;
//		}
//
//		String gender = s.getGender();
//
//		if (gender == null || gender.isEmpty()) {
//			return false;
//		}
//
//		String emailId = s.getEmailId();
//
//		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailId);
//
//		if (emailId == null || emailId.isEmpty() || !matcher.matches()) {
//			return false;
//		}
//
//		String movies = s.getMovie();
//
//		if (movies == null || movies.isEmpty()) {
//			return false;
//		}
//
//		Long mobileNo = s.getMobileNo();
//
//		if (mobileNo == null || mobileNo.toString().length() != 10) {
//			return false;
//		}
//
//		String address = s.getAddress();
//
//		if (address == null || address.isEmpty()) {
//			return false;
//		}
//
//		String pincode = s.getPinCode();
//
//		if (pincode == null || pincode.isEmpty() || pincode.length() != 6) {
//			return false;
//		}
//
//		return true;
//	}

	String validateData(SuperHero s) {
		Long id = s.getId();
		
		String string = "";

		if (id == null) {
			string += "ID is not valid";
			string += "\n ";
		}

		String name = s.getName();

		if (name == null || name.isEmpty()) {
			string += "Name is not valid ";
			string += "\n ";
		}

		String username = s.getUsername();

		if (username == null || username.isEmpty() || username.length() < 5) {
			string += "Username is not valid";
			string += "\n ";
		}

		String gender = s.getGender();

		if (gender == null || gender.isEmpty()) {
			string += "Gender is not valid ";
			string += "\n ";
		}

		String emailId = s.getEmailId();

		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailId);

		if (emailId == null || emailId.isEmpty() || !matcher.matches()) {
			string += "Email-ID is not valid ";
			string += "\n ";
		}

		String movies = s.getMovie();

		if (movies == null || movies.isEmpty()) {
			string += "Movie List is not valid ";
			string += "\n ";
		}

		Long mobileNo = s.getMobileNo();

		if (mobileNo == null || mobileNo.toString().length() != 10) {
			string += "Mobile No. is not valid ";
			string += "\n ";
		}

		String address = s.getAddress();

		if (address == null || address.isEmpty()) {
			string += "Address is not valid ";
			string += "\n ";
		}

		String pincode = s.getPinCode();

		if (pincode == null || pincode.isEmpty() || pincode.length() != 6) {
			string += "Pincode is not valid ";
			string += "\n ";
		}

		return string;
	}
}
