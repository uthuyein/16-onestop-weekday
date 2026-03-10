package com.jdc.mkt.entity;

import java.util.List;
import java.util.Map;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "collection_three_tbl")
public class CollectionDataThreee {

	@Id
	private int id;
	
	@ElementCollection
	private List<EmbeddedData> lists;
	
	
	@ElementCollection
	private Map<Integer, EmbeddedData> maps;
	
	
	
}









