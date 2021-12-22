package com.vasu.SpringDataJpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vasu.SpringDataJpa.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{

}
