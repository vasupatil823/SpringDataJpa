package com.vasu.SpringDataJpa.test;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.vasu.SpringDataJpa.entity.Student;
import com.vasu.SpringDataJpa.repository.StudentRepository;

@SpringBootTest
public class PagingAndSortingTest {

	@Autowired
	StudentRepository studentRepo;

	@Test
	public void findAllPagination() {
		Pageable firstPageWithTwoElements = PageRequest.of(0, 2);
		Pageable secondPageWithThreeElements = PageRequest.of(1, 3);
		List<Student> studentList = studentRepo.findAll(firstPageWithTwoElements).getContent();
		Long TotalElements = studentRepo.findAll(firstPageWithTwoElements).getTotalElements();
		int totalPages = studentRepo.findAll(firstPageWithTwoElements).getTotalPages();
		System.out.println("Student List with Paging and Sorting is :" + studentList);
		System.out.println("Total Elements are : " + TotalElements);
		System.out.println("Total Pages are : " + totalPages);
	}
    @Test
	public void findAllSorting() {
    Pageable sortByFirstName = PageRequest.of(0, 2, Sort.by("firstName").descending());
    List<Student> studentSortedList = studentRepo.findAll(sortByFirstName).getContent();
    System.out.println("Sorting by First Name is : "+studentSortedList);
	}
    @Test
	public void findAllContainingFirstName() {
    Pageable sortByFirstName = PageRequest.of(0, 3);
    List<Student> studentSortedList = studentRepo.findByFirstNameContaining(sortByFirstName,"vasu").getContent();
    System.out.println("List of students containing vasu as first name is : "+studentSortedList);
	}
}
