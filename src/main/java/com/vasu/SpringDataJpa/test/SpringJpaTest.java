package com.vasu.SpringDataJpa.test;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.vasu.SpringDataJpa.entity.Course;
import com.vasu.SpringDataJpa.entity.CourseMaterial;
import com.vasu.SpringDataJpa.entity.Guardian;
import com.vasu.SpringDataJpa.entity.Student;
import com.vasu.SpringDataJpa.repository.CourseMaterialRepository;
import com.vasu.SpringDataJpa.repository.CourseRepository;
import com.vasu.SpringDataJpa.repository.StudentRepository;

@SpringBootTest
public class SpringJpaTest {

	@Autowired
	StudentRepository repos;
	
	@Autowired
	CourseRepository courseRepo;
	
	@Autowired
	CourseMaterialRepository courseMaterialRepo;

//commented for only for running saveStudentWithGuardian() method
	/*
	 * @Test public void saveStudent() { Student student =
	 * Student.builder().emailId("sandeep@gmail.com").firstName("Sandeep").lastName(
	 * "Patil") //.gardianName("efgh") //.guardianEmail("efgh@gmail.com")
	 * //.guardianMoNo("8989898989") .build(); repos.save(student); }
	 */
	/*
	 * @Test public void saveStudentWithGuardian() { Guardian guardian =
	 * Guardian.builder().email("guardian1@gmail.com") .mobile("12345678910")
	 * .name("Guardian1").build(); Student student =
	 * Student.builder().emailId("student1@gmail.com").firstName("Student1").
	 * lastName("Patil") .guardian(guardian) .build(); repos.save(student); }
	 */
	@Test
	public void printAllStudent() {
		List<Student> studentList = repos.findAll();
		System.out.println("********All the students are ********:\n" + studentList);
	}

	@Test
	public void printStudentByFirstName() {
		List<Student> studentList = repos.findByFirstName("Student1");
		System.out.println("********Student By First Name are as :\n" + studentList);
	}

	@Test
	public void printStudentByFirstNameContains() {
		List<Student> studentList = repos.findByFirstNameContaining("1");
		System.out.println("********Student By First Name Contains given chanracter are as :\n" + studentList);
	}

	@Test
	public void printStudentByLastNameNotNull() {
		List<Student> studentList = repos.findByLastNameNotNull();
		System.out.println("********Student By Last Name is not null are as :\n" + studentList);
	}

	@Test
	public void printStudentByGuardianName() {
		List<Student> studentList = repos.findByGuardianName("Guardian1");
		System.out.println("********Student By Guardian name are as :\n" + studentList);
	}

	@Test
	public void printStudentByEmailAddress() {
		Student studentList = repos.getStudentByEmailAddress("vasu@gmail.com");
		System.out.println("********Student By Email address is :\n" + studentList);
	}

	@Test
	public void printStudentFirstNameByEmailAddress() {
		String studentFirstName = repos.getStudentFirstNameByEmailAddress("vasu@gmail.com");
		System.out.println("********Student First Name By Email address is :\n" + studentFirstName);
	}

	@Test
	public void printStudentByEmailAddressNative() {
		Student studentFirstName = repos.getStudentByEmailAddressNative("vasu@gmail.com");
		System.out.println("********Student ByE mail address Native is :\n" + studentFirstName);
	}

	@Test
	public void printStudentByEmailAddressNativeNamedParam() {
		Student studentFirstName = repos.getStudentByEmailAddressNativeNamedParam("vasu@gmail.com");
		System.out.println("********Student ByE mail address Native Named Param is :\n" + studentFirstName);
	}

	@Test
	public void printStudentFirstNameByEmailAddressNativeNamedParam() {
		String studentFirstName = repos.getStudentFirstNameByEmailAddressNativeNamedParam("vasu@gmail.com");
		System.out.println("********Student First Name by mail address Native Named Param is :\n" + studentFirstName);
	}

	@Test
	public void updateFirstNameByEmailAddressNativeNamedParam() {
		int result = repos.updateFirstNameByEmailAddressNativeNamedParam("Vasudev","vasu@gmail.com");
		System.out.println("********update First Name by mail address Native Named Param is :\n" + result);
	}
	
	@Test
	public void saveCourseMaterial() { 
		Course course = Course.builder().title("Java Course")
				.credit("10")
				.build();
		CourseMaterial courseMaterial = CourseMaterial.builder().url("www.google.com")
				.course(course).build();
		courseMaterialRepo.save(courseMaterial);
	}
	
	@Test
	public void printAllCourseMaterials() { 
		List<CourseMaterial> courseMaterial = courseMaterialRepo.findAll();
		System.out.println("Course Material fetched is : " +courseMaterial);
	}
}
