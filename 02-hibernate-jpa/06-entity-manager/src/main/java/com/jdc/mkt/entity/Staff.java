package com.jdc.mkt.entity;

import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@DiscriminatorValue("2")
@EqualsAndHashCode(callSuper = false)
public class Staff extends Account{
	

	@ElementCollection
	@CollectionTable(
			name = "information_tbl",
			joinColumns = {
					@JoinColumn(name = "staff_id")
			})
	private List<String> informations;
	
	public Staff() {
		setRole(Role.STAFF);
	}
	
}
