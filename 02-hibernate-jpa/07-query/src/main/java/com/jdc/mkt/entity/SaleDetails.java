package com.jdc.mkt.entity;

import com.jdc.mkt.entity.listeners.EnableTimerListener;
import com.jdc.mkt.entity.listeners.Times;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "sale_details_tbl")
public class SaleDetails implements EnableTimerListener{

	@EmbeddedId
	private SaleDetailPk id;
	
	private int qty;
	
	@Embedded
	private Times times;
	
	@Column(name = "sale_price")
	private double salePrice;
	
	@ManyToOne
	@MapsId("saleId")
	private Sale sale;
	
	@ManyToOne
	@MapsId("medicineId")
	private Medicine medicine;
	
}
