package com.jdc.mkt.entity;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class SaleDetailPk implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Column(name="sale_id")
	private UUID saleId;
	
	@Column(name="medicine_id")
	private int medicineId;
	
	private LocalTime createTime;
}
