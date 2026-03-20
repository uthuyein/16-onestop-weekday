package com.jdc.mkt.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@DiscriminatorValue("3")
public class Teacher extends Account{

	private String teaching;
	
	public Teacher(String loginId,String pass) {
		super(loginId,pass);
		setRole(Role.TEACHER);
	}
}
