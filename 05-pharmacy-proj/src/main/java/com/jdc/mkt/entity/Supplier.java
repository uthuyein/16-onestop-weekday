package com.jdc.mkt.entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "supplier_tbl")
public class Supplier {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false,length = 45)
	private String name;
	
	@Embedded
	private Contact primary;
	
	@Embedded
	@AttributeOverride(name = "email",column = @Column(name = "secondary_email"))
	@AttributeOverride(name = "phone",column = @Column(name = "secondary_phone"))
	private Contact secondary;
	
	@Column(columnDefinition = "tinyint(1) default 1")
	private boolean isActive;
}
