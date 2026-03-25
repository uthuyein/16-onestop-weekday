package com.jdc.mkt.entity;

import java.time.LocalDate;
import java.util.UUID;

import com.jdc.mkt.entity.listeners.EnableTimerListener;
import com.jdc.mkt.entity.listeners.Times;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
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
public class Purchase implements EnableTimerListener{

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Supplier supplier;
	
	@Embedded
	private Times times;
	
	private LocalDate issueDate;
}
