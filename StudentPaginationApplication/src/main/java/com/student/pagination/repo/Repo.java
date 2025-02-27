package com.student.pagination.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.student.pagination.domain.HelperEntity;
import com.student.pagination.domain.StudentEntity;
import com.student.pagination.proxy.StudentProxy;

import jakarta.transaction.Transactional;

@Transactional
public interface Repo extends JpaRepository<StudentEntity, Long> {
	List<StudentEntity> findByAddress(String address);

	List<StudentEntity> findByEmailId(String emailId);

	List<StudentEntity> findByFirstName(String firstName);

	List<StudentEntity> findByLastName(String lastName);

	List<StudentEntity> findByMobileNo(String mobileNo);

	List<StudentEntity> findByPinCode(String pinCode);

	List<StudentEntity> findByFirstNameAndLastName(String firstName, String lastName);

	List<StudentEntity> findByFirstNameAndEmailId(String firstName, String emailId);

	List<StudentEntity> findByFirstNameOrLastName(String firstName, String lastName);

	List<StudentEntity> findByFirstNameLike(String firstName);

	List<StudentEntity> findByIdBetween(Long start, Long end);

	List<StudentEntity> findByFirstNameOrderByLastNameDesc(String firstname);

	void deleteByFirstName(String firstname);

	@Query(value = "SELECT s FROM StudentEntity s WHERE s.firstName=:firstname AND s.lastName=:lastname")
	List<StudentEntity> getStudentByFirstNameAndLastName(@Param("firstName") String firstname,
			@Param("lastname") String lastname);

	@Modifying
	@Query(value = "DELETE FROM StudentEntity s WHERE s.firstName=:firstname AND s.lastName=:lastname")
	void deleteStudentData(@Param("firstname") String firstname, @Param("lastname") String lastname);

	@Modifying
	@Query(value = "UPDATE StudentEntity s SET s.firstName=:firstname, s.lastName=:lastname WHERE s.id=:id")
	void updateStudentData(@Param("id") Long id, @Param("firstname") String firstname,
			@Param("lastname") String lastname);

	@Modifying
	@Query(value = "INSERT INTO StudentEntity (firstName, lastName, emailId) VALUES (:firstname, :lastname, :emailid)")
	void insertStudentData(@Param("firstname") String firstname, @Param("lastname") String lastname,
			@Param("emailid") String emailid);

	@Query(value = "SELECT new StudentEntity(s.firstName, s.lastName) FROM StudentEntity s WHERE s.emailId=:emailid")
	StudentEntity selectStudentData(@Param("emailid") String emailid);

	@Query(value = "SELECT new HelperEntity(s.pinCode, COUNT(s)) FROM StudentEntity s GROUP BY s.pinCode ORDER BY s.pinCode DESC")
	List<HelperEntity> getStudentByPincode();

	@Query(value = "SELECT pin_code, COUNT(*) AS total_count FROM student_entity GROUP BY pin_code ORDER BY total_count DESC", nativeQuery = true)
	List<Object[]> getStudentByPincodeUsingNative();

	@Modifying
	@Query(value = "DELETE FROM student_entity WHERE first_name=? AND last_name=?", nativeQuery = true)
	void deleteStudentDataUsingNative(@Param("firstname") String firstname, @Param("lastname") String lastname);
}
