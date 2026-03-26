package com.jdc.mkt.entity;

import com.jdc.mkt.entity.listeners.EnableTimerListener;
import com.jdc.mkt.entity.listeners.Times;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "medicine_tbl")
@NamedQuery(name = "Medicine.findAll",
			query = "select m from Medicine m where m.isActive is true")
public class Medicine implements EnableTimerListener{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false,length = 45)
	private String name;
	
	@Column(name = "label_price")
	private double labelPrice;
	
	@Embedded
	private Times times;
	
	@Column(name="is_active", columnDefinition = "tinyint(1) default 1")
	private boolean isActive;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Category category;
}
