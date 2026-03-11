package com.jdc.mkt.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "license_tbl")
public class License {

	@Id
	private int id;
	private LocalDate dob;
}
