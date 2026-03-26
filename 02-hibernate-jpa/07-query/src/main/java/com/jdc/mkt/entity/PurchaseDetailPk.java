package com.jdc.mkt.entity;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class PurchaseDetailPk implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Column(name = "purchase_id",length = 36)
	private UUID purchaseId;
	
	@Column(name = "medicine_id")
	private int medicineId;
	@Column(name = "purchase_time")
	private LocalTime purchaseTime;
}
