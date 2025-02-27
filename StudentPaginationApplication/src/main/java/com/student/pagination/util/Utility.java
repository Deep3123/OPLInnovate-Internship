package com.student.pagination.util;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.student.pagination.domain.HelperEntity;
import com.student.pagination.domain.StudentEntity;
import com.student.pagination.proxy.HelperProxy;
import com.student.pagination.proxy.StudentProxy;

@Component
public class Utility {
	@Autowired
	private ObjectMapper objectMapper;

	public StudentProxy StudentEntitytoStudentProxy(StudentEntity studentEntity) {
		return objectMapper.convertValue(studentEntity, StudentProxy.class);
	}

	public StudentEntity StudentProxytoStudentEntity(StudentProxy studentProxy) {
		return objectMapper.convertValue(studentProxy, StudentEntity.class);
	}

	public List<StudentEntity> ListofStudentProxytoStudentEntity(List<StudentProxy> studentProxies) {
		return studentProxies.stream().map(obj -> StudentProxytoStudentEntity(obj)).collect(Collectors.toList());
	}

	public List<StudentProxy> ListofStudentEntitytoStudentProxy(List<StudentEntity> studentEntities) {
		return studentEntities.stream().map(obj -> StudentEntitytoStudentProxy(obj)).collect(Collectors.toList());
	}

	public List<HelperProxy> ListofHelperEntitytoHelperProxy(List<HelperEntity> helperEntities) {
		return helperEntities.stream().map(obj -> objectMapper.convertValue(obj, HelperProxy.class))
				.collect(Collectors.toList());
	}
}