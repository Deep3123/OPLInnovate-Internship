package com.ems.filehandling.proxy;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(Include.NON_NULL)
public class EmployeeProfileImageProxy {
	private Long id;
	private String fileName;
	private String fileId;
	private Long fileSize;
	private String contentType;
	private byte[] fileData;
	private ErrorData errorData;
//	private LocalDateTime localDateTime;

	public EmployeeProfileImageProxy(ErrorData errorData) {
		this.errorData = errorData;
	}
}
