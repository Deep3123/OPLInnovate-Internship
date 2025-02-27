package com.sms.management.util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sms.management.domain.Author;
import com.sms.management.domain.Books;
import com.sms.management.domain.Branch;
import com.sms.management.domain.MobileNo;
import com.sms.management.domain.Student;
import com.sms.management.proxy.AuthorProxy;
import com.sms.management.proxy.BooksProxy;
import com.sms.management.proxy.BranchProxy;
import com.sms.management.proxy.MobileNoProxy;
import com.sms.management.proxy.StudentProxy;

@Component
public class MapperUtils {
	@Autowired
	private ObjectMapper objectMapper;

	public StudentProxy StudentEntitytoStudentProxy(Student student) {
		return objectMapper.convertValue(student, StudentProxy.class);
	}

	public Student StudentProxytoStudentEntity(StudentProxy studentProxy) {
		return objectMapper.convertValue(studentProxy, Student.class);
	}

	public BranchProxy BranchEntitytoBranchProxy(Branch branch) {
		return objectMapper.convertValue(branch, BranchProxy.class);
	}

	public Branch BranchProxytoBranchEntity(BranchProxy branchProxy) {
//		System.out.println(branchProxy.getBranchId());
//		System.out.println(branchProxy.getBranchName());
//		System.out.println(branchProxy.getBranchDescription());
//
//		// Log the student details
//		System.out.println(branchProxy.getStudent().getStudentId());
//		System.out.println(branchProxy.getStudent().getStudentName());
//		System.out.println(branchProxy.getStudent().getStudentGender());
//		System.out.println(branchProxy.getStudent().getStudentDob());
//		System.out.println(branchProxy.getStudent().getStudentAddress());
//		System.out.println(branchProxy.getStudent().getStudentBranch());
//
//		// Map Student Proxy to Student entity
//		Student student = new Student();
//
//		// Check if the ID is valid before setting it
//		if (branchProxy.getStudent().getStudentId() != null) {
//			student.setStudentId(branchProxy.getStudent().getStudentId()); // Ensure valid ID
//		} else {
//			student.setStudentId(null); // Handle the case where ID is not available, if needed
//		}
//
//		student.setStudentAddress(branchProxy.getStudent().getStudentAddress());
//		student.setStudentName(branchProxy.getStudent().getStudentName());
//		student.setStudentGender(branchProxy.getStudent().getStudentGender());
//		student.setStudentDob(branchProxy.getStudent().getStudentDob());
//		student.setStudentBranch(null); // Set the branch relationship properly, as needed
//
//		// Now map Branch entity
//		Branch branch = new Branch();
//		branch.setBranchId(branchProxy.getBranchId());
//		branch.setBranchName(branchProxy.getBranchName());
//		branch.setBranchDescription(branchProxy.getBranchDescription());
//		branch.setStudent(student); // Set the student for this branch
//
//		// Log the mapped entity details
//		System.out.println(branch.getBranchId());
//		System.out.println(branch.getBranchName());
//		System.out.println(branch.getBranchDescription());
//
//		System.out.println(branch.getStudent().getStudentId());
//		System.out.println(branch.getStudent().getStudentName());
//		System.out.println(branch.getStudent().getStudentGender());
//		System.out.println(branch.getStudent().getStudentDob());
//		System.out.println(branch.getStudent().getStudentAddress());
//		System.out.println(branch.getStudent().getStudentBranch());
//
//		return branch;

		return objectMapper.convertValue(branchProxy, Branch.class);
	}

	public List<StudentProxy> ListofStudentEntitytoStudentProxy(List<Student> student) {
//		return student.stream().map(obj -> objectMapper.convertValue(obj, StudentProxy.class))
//				.collect(Collectors.toList());

		List<StudentProxy> studentProxies = new ArrayList<>();

		for (Student st : student) {
			st.getStudentBranch().setStudent(null);
			st.getMobileNo().stream().forEach(obj -> obj.setStd(null));
			studentProxies.add(StudentEntitytoStudentProxy(st));
		}
		return studentProxies;
	}

	public List<BranchProxy> ListofBranchEntitytoBranchProxy(List<Branch> branch) {
//		return branch.stream().map(obj -> objectMapper.convertValue(obj, BranchProxy.class))
//				.collect(Collectors.toList());

		List<BranchProxy> branchProxies = new ArrayList<>();

		for (Branch br : branch) {
			br.getStudent().setStudentBranch(null);
//			br.getStudent().getStudentBranch().setStudent(null);
			br.getStudent().getMobileNo().stream().forEach(obj -> obj.setStd(null));
			branchProxies.add(BranchEntitytoBranchProxy(br));
		}
		return branchProxies;
	}

	public List<MobileNo> ListofMobileNoProxytoMobileNoEntity(List<MobileNoProxy> list) {
		return list.stream().map(obj -> objectMapper.convertValue(obj, MobileNo.class)).collect(Collectors.toList());
	}

	public List<MobileNoProxy> ListofMobileNoEntitytoMobileNoProxy(List<MobileNo> list) {
		list.stream().forEach(obj -> obj.getStd().getStudentBranch().setStudent(null));
		list.stream().forEach(obj -> obj.getStd().setMobileNo(null));
		return list.stream().map(obj -> objectMapper.convertValue(obj, MobileNoProxy.class))
				.collect(Collectors.toList());
	}

	public MobileNo MobileNoProxytoMobileNoEntity(MobileNoProxy mobileNoProxy) {
		return objectMapper.convertValue(mobileNoProxy, MobileNo.class);
	}

//	public List<Student> ListofStudentProxytoStudentEntity(List<StudentProxy> studentProxies) {
////		return student.stream().map(obj -> objectMapper.convertValue(obj, StudentProxy.class))
////				.collect(Collectors.toList());
//
//		List<Student> students = new ArrayList<>();
//
//		for (StudentProxy st : studentProxies) {
//			st.getStudentBranch().setStudent(null);
//			students.add(StudentProxytoStudentEntity(st));
//		}
//		return students;
//	}

//	public List<StudentProxy> ListofStudentEntitytoStudentProxy2(List<Student> student) {
////		return student.stream().map(obj -> objectMapper.convertValue(obj, StudentProxy.class))
////				.collect(Collectors.toList());
//
//		List<StudentProxy> studentProxies = new ArrayList<>();
//
//		for (Student st : student) {
//			st.getStudentBranch().setStudent(null);
//			st.setMobileNo(null);
//			studentProxies.add(StudentEntitytoStudentProxy(st));
//		}
//		return studentProxies;
//	}

	public List<AuthorProxy> ListofAuthorEntitytoAuthorProxy(List<Author> list) {
		return list.stream().map(obj -> objectMapper.convertValue(obj, AuthorProxy.class)).collect(Collectors.toList());
	}

	public List<Author> ListofAuthorProxytoAuthorEntity(List<AuthorProxy> list) {
		return list.stream().map(obj -> objectMapper.convertValue(obj, Author.class)).collect(Collectors.toList());
	}

	public Author AuthorProxytoAuthorEntity(AuthorProxy authorProxy) {
		return objectMapper.convertValue(authorProxy, Author.class);
	}

	public AuthorProxy AuthorEntitytoAuthorProxy(Author author) {
		return objectMapper.convertValue(author, AuthorProxy.class);
	}

	public List<BooksProxy> ListofBooksEntitytoBooksProxy(List<Books> list) {
		return list.stream().map(obj -> objectMapper.convertValue(obj, BooksProxy.class)).collect(Collectors.toList());
	}

	public List<Books> ListofBooksProxytoBooksEntity(List<BooksProxy> list) {
		return list.stream().map(obj -> objectMapper.convertValue(obj, Books.class)).collect(Collectors.toList());
	}

	public Books BooksProxytoBooksEntity(BooksProxy booksProxy) {
		return objectMapper.convertValue(booksProxy, Books.class);
	}

	public BooksProxy BooksEntitytoBooksProxy(Books books) {
		return objectMapper.convertValue(books, BooksProxy.class);
	}
}