package com.ems.filehandling.util;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.ems.filehandling.domain.EmployeeEntity;
import com.ems.filehandling.domain.EmployeeProfileImage;
import com.ems.filehandling.proxy.EmployeeProfileImageProxy;
import com.ems.filehandling.proxy.EmployeeProxy;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class MapperUtil {
	public static EmployeeProfileImageProxy convertEntitytoProxy(EmployeeProfileImage employeeProfileImage) {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.convertValue(employeeProfileImage, EmployeeProfileImageProxy.class);
	}

	public static EmployeeProfileImage convertProxytoEntity(EmployeeProfileImageProxy employeeProfileImage) {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.convertValue(employeeProfileImage, EmployeeProfileImage.class);
	}

	public static List<EmployeeProfileImageProxy> convertListOfEntitytoProxy(
			List<EmployeeProfileImage> employeeProfileImage) {
		return employeeProfileImage.stream().map(obj -> convertEntitytoProxy(obj)).collect(Collectors.toList());
	}

	public static EmployeeEntity convertEmployeeProxytoEntity(EmployeeProxy employeeProxy) {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.convertValue(employeeProxy, EmployeeEntity.class);
	}
}