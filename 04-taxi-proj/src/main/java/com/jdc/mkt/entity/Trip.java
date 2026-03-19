package com.jdc.mkt.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="trip_tbl")
public class Trip {

	@EmbeddedId
	private TripPk id;
	
	private String status;
	private String source;
	private String destination;
	
	@ManyToOne
//	@JoinColumn(insertable = false,updatable = false)
	@MapsId("paymentId")
	private Payment payment;
	@ManyToOne
//	@JoinColumn(insertable = false,updatable = false)
	@MapsId("passengerId")
	private Passenger passenger;
	@ManyToOne
//	@JoinColumn(insertable = false,updatable = false)
	@MapsId("driverId")
	private Driver driver;
}
