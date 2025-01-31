package com.main.urlproject.student;

public class Student {
	private String name;
	private Integer enrollment_no;
	private String college_name;
	private String address;
	private Integer mobile_no;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getEnrollment_no() {
		return enrollment_no;
	}

	public void setEnrollment_no(Integer enrollment_no) {
		this.enrollment_no = enrollment_no;
	}

	public String getCollege_name() {
		return college_name;
	}

	public void setCollege_name(String college_name) {
		this.college_name = college_name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getMobile_no() {
		return mobile_no;
	}

	public void setMobile_no(Integer mobile_no) {
		this.mobile_no = mobile_no;
	}

	public Student(String name, Integer enrollment_no, String college_name, String address, Integer mobile_no) {
		super();
		this.name = name;
		this.enrollment_no = enrollment_no;
		this.college_name = college_name;
		this.address = address;
		this.mobile_no = mobile_no;
	}

	public Student() {
		super();
	}

}