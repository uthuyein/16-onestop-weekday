package com.jdc.mkt.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "employee_tbl")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false,length = 45)
	private String name;
	
	@Enumerated(EnumType.STRING)
	private Role role;
	
	@Embedded
	private Contact contact;
	
	@Column(columnDefinition = "tinyint(1) default 1")
	private boolean isActive;
	
	public enum Role{
		CASHIER,MANAGER,ADMIN
	}
}
