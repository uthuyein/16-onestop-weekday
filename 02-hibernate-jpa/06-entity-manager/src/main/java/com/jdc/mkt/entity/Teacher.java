package com.jdc.mkt.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
@DiscriminatorValue("3")
public class Teacher extends Account{

	private String teaching;
	
	public Teacher() {
		setRole(Role.TEACHER);
	}
}
