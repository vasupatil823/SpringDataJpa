package com.vasu.SpringDataJpa.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vasu.SpringDataJpa.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

	public List<Student> findByFirstName(String firstName);

	public List<Student> findByFirstNameContaining(String name);

	public List<Student> findByLastNameNotNull();

	public List<Student> findByGuardianName(String name);

	// for more methods like this refer the Spring Data JPA Reference Documentation
	// :
	// https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods
	// JPQL queries
	@Query("select s from Student s where s.emailId=?1")
	public Student getStudentByEmailAddress(String emailid);

	@Query("select s.firstName from Student s where s.emailId=?1")
	public String getStudentFirstNameByEmailAddress(String emailid);

	// Native
	@Query(value = "select * from student s where s.email_address=?1", nativeQuery = true)
	public Student getStudentByEmailAddressNative(String emailid);

	// Native Named Param
	@Query(value = "select * from student s where s.email_address= :emailid", nativeQuery = true)
	public Student getStudentByEmailAddressNativeNamedParam(@Param("emailid") String emailid);

	// Native Named Param
	@Query(value = "select first_name from student s where s.email_address= :emailid", nativeQuery = true)
	public String getStudentFirstNameByEmailAddressNativeNamedParam(@Param("emailid") String emailid);

	// Native update query using Named Param
	@Modifying
	@Transactional
	@Query(value = "update student set first_name= :firstName where email_address= :emailid", nativeQuery = true)
	public int updateFirstNameByEmailAddressNativeNamedParam(@Param("firstName") String firstName,
			@Param("emailid") String emailid);
	
	// Custom method for Paging and Sorting
	Page<Student> findByFirstNameContaining(Pageable pagaeble, String firstName);
}
