package com.vasu.SpringDataJpa.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "course")
public class CourseMaterial {
	@Id
	@SequenceGenerator(
			sequenceName = "courseMaterial_sequence",
			allocationSize = 1,
			 name = "courseMaterial_sequence"
			)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "courseMaterial_sequence"
			)
	private long courseMaterialId;
	private String url;
	
	@OneToOne(cascade = CascadeType.ALL,
			//fetch = FetchType.LAZY
			fetch = FetchType.EAGER)
	@JoinColumn(
			name = "course_id",
			referencedColumnName = "courseId"
			)
	//we can define all other things here
	private Course course;

}
