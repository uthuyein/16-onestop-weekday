package com.jdc.mkt.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@DiscriminatorValue("4")
public class Student extends Account{

	@ManyToOne
	private Course course;
	
	public Student (String loginId,String pass) {
		super(loginId,pass);
		setRole(Role.STUDENT);
	}
}
