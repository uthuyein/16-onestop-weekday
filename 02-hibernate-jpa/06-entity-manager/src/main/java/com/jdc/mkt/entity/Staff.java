package com.jdc.mkt.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@DiscriminatorValue("2")
@EqualsAndHashCode(callSuper = false)
public class Staff extends Account{
	

	@ElementCollection
	@CollectionTable(
			name = "information_tbl",
			joinColumns = {
					@JoinColumn(name = "staff_id")
			})
	private List<String> informations ;
	
	{
		setRole(Role.STAFF);
		informations = new ArrayList<String>();
	}
	
	public Staff(String loginId,String pass) {
		super(loginId,pass);
	}
	
	
	public void addInfo(String...infos) {
		for(String str : infos) {
			informations.add(str);
		}
	}
	
}
