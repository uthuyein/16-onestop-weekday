package com.jdc.mkt.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class TripPk implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Column(name = "payment_id")
	private int paymentId;
	@Column(name = "passenger_id")
	private int passengerId;
	@Column(name = "driver_id")
	private int driverId;
	
	private LocalDateTime createAt;
}
