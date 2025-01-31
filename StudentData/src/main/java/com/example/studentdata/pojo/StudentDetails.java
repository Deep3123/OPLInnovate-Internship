package com.example.studentdata.pojo;

public class StudentDetails {
	private String name;
	private Integer enrollment_no;
	private String address;
	private Integer mobile_no;
	private String gender;
	private String dob;
	private String college_name;
	private String nationality;
	private String current_job;
	private String hobby;
	private String marital_status;

	public StudentDetails(String name, Integer enrollment_no, String address, Integer mobile_no, String gender,
			String dob, String college_name, String nationality, String current_job, String hobby,
			String marital_status) {
		super();
		this.name = name;
		this.enrollment_no = enrollment_no;
		this.address = address;
		this.mobile_no = mobile_no;
		this.gender = gender;
		this.dob = dob;
		this.college_name = college_name;
		this.nationality = nationality;
		this.current_job = current_job;
		this.hobby = hobby;
		this.marital_status = marital_status;
	}

	public StudentDetails() {
		super();
	}

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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getCollege_name() {
		return college_name;
	}

	public void setCollege_name(String college_name) {
		this.college_name = college_name;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getCurrent_job() {
		return current_job;
	}

	public void setCurrent_job(String current_job) {
		this.current_job = current_job;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public String getMarital_status() {
		return marital_status;
	}

	public void setMarital_status(String marital_status) {
		this.marital_status = marital_status;
	}
}