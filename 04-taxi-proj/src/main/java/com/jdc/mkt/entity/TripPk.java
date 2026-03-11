package com.jdc.mkt.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class TripPk implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int paymentId;
	private int passengerId;
	private int driverId;
	
	private LocalDateTime createAt;
}
