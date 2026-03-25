package com.jdc.mkt.entity;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "purchase_tbl")
public class Purchase {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Supplier supplier;
	
	private LocalDate issueDate;
}
