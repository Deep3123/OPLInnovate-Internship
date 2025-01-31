package com.example.studentdata.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.studentdata.pojo.StudentDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@ResponseBody
public class StudController {
	@RequestMapping(value = "/getBiodata", method = RequestMethod.GET)
	public StudentDetails getBiodataDetails() {
		StudentDetails st = new StudentDetails("John Doe", // name
				123456, // enrollment_no
				"1234 Elm St, City", // address
				987654321, // mobile_no
				"Male", // gender
				"01/01/1998", // dob
				"XYZ University", // college_name
				"American", // nationality
				"Software Engineer", // current_job
				"Reading", // hobby
				"Single" // marital_status
		);

		return st;
	}

}
