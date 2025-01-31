package com.main.urlproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.main.urlproject.student.Student;

@Controller
@ResponseBody
public class UrlController {
	@RequestMapping(value = "/data/{name}/{enrollment_no}/{college_name}/{address}/{mobile_no}", method = RequestMethod.GET)
	public Student getData(@PathVariable(value = "name") String name,
			@PathVariable(value = "enrollment_no") Integer enrollment_no,
			@PathVariable(value = "college_name") String college_name, @PathVariable(value = "address") String address,
			@PathVariable(value = "mobile_no") Integer mobile_no) {

		Student st = new Student();

		st.setName(name);
		st.setEnrollment_no(enrollment_no);
		st.setCollege_name(college_name);
		st.setAddress(address);
		st.setMobile_no(mobile_no);

		return st;
	}

	@RequestMapping(value = "/newdata", method = RequestMethod.GET)
	public Student newGetData(@RequestParam(value = "name") String name,
			@RequestParam(value = "enrollment_no") Integer enrollment_no,
			@RequestParam(value = "college_name") String college_name, @RequestParam(value = "address") String address,
			@RequestParam(value = "mobile_no") Integer mobile_no) {

		Student st = new Student();

		st.setName(name);
		st.setEnrollment_no(enrollment_no);
		st.setCollege_name(college_name);
		st.setAddress(address);
		st.setMobile_no(mobile_no);

		return st;
	}
}
