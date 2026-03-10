package com.jdc.mkt.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "human_tbl")
//@IdClass(HumanClassPk.class)
public class Human {

//	@EmbeddedId
//	private HumanPk id;
	private String name;
	
	@Id
	private String phone;
	@Id
	private String email;
}
