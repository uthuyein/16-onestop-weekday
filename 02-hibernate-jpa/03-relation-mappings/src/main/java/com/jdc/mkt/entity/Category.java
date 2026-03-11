package com.jdc.mkt.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "category_tbl")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false,length = 45,unique = true)
	private String name;
	
	@Column(columnDefinition = "tinyint(1) not null default 1")
	private boolean isActive;
	
	@OneToMany
	@JoinTable(name = "cat_prod_tbl")
//	@JoinColumn(name = "cat_id")
	private List<Product>products;
}
