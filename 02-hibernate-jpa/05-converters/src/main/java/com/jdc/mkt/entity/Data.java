package com.jdc.mkt.entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Data {

	@Id
	private int id;
	@Convert(converter = StringConverter.class)
	private String value;
	
	private SubData data1;
	
	@AttributeOverride(name = "child",column = @Column(name = "sub_child"))
	@AttributeOverride(name = "count",column = @Column(name = "sub_count"))
	private SubData data2;
	
}
