package com.vasu.SpringDataJpa.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@AttributeOverrides(
		{
			@AttributeOverride(
					name="name",
					column = @Column(name="gardian_name")
					
					),
			@AttributeOverride(
					name="email",
					column = @Column(name="guardian_email")
					),
			@AttributeOverride(
					name="mobile",
					column = @Column(name="guardian_mo_no")
					)
		}
		
		)
public class Guardian {
	
	private String name;
	private String email;
	private String mobile;

}
