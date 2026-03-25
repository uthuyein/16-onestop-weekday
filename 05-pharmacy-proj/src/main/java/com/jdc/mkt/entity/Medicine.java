package com.jdc.mkt.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "medicine_tbl")
public class Medicine {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false,length = 45)
	private String name;
	
	@Column(name = "label_price")
	private double labelPrice;
	
	@Column(columnDefinition = "tinyint(1) default 1")
	private boolean isActive;
	
	@ManyToOne
	private Category category;
}
