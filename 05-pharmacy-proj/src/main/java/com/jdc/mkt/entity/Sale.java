package com.jdc.mkt.entity;

import java.time.LocalDate;
import java.util.UUID;

import com.jdc.mkt.entity.listeners.EnableTimerListener;
import com.jdc.mkt.entity.listeners.Times;

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
@Table(name = "sale_tbl")
public class Sale implements EnableTimerListener{

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	@Embedded
	private Times times;
	
	@ManyToOne
	private Customer customer;
	@ManyToOne
	private Employee employee;
	
	private LocalDate saleDate;
}
