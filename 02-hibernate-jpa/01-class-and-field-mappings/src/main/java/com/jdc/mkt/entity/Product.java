package com.jdc.mkt.entity;

import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;
import lombok.Data;

@Data
@Entity
@Table(name = "product_tbl")
public class Product {

	@Id
	private int id;
	
	@Column(nullable = true,length = 45,name = "product")
	private String name;
	
	@Column(columnDefinition = "double(7,2) not null default 1.00")
	private double price;
	
	@Enumerated(EnumType.STRING)
	private Size size;
	
	@Temporal(TemporalType.DATE)
	private Date createDate;
	
	private  LocalDate updateDate;
	
	@Transient
	private Boolean checker;
	
	public enum Size{
		SMALL,MEDIUM,LARGE
	}
}






