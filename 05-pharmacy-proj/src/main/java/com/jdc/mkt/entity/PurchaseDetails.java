package com.jdc.mkt.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "purchase_detail_tbl")
public class PurchaseDetails {

	@EmbeddedId
	private PurchaseDetailPk id;
	
	private int qty;
	
	@Column(name = "purchase_price")
	private double purchasePrice;
	
	@ManyToOne
	@MapsId("purchaseId")
	private Purchase purchase;
	
	@ManyToOne
	@MapsId("medicineId")
	private Medicine medicine;
}
