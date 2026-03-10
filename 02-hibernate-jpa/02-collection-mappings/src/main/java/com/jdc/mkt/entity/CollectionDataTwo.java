package com.jdc.mkt.entity;

import java.util.List;
import java.util.Map;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapKeyColumn;
import jakarta.persistence.MapKeyEnumerated;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;
import lombok.Data;

@Data
//@Entity
@Table(name = "collection_two_tbl")
public class CollectionDataTwo {

	@Id
	private int id;
	
	@OrderBy("lists asc")
	@ElementCollection
	@Enumerated(EnumType.STRING)
	@CollectionTable(
			name = "lists_tbl",
			joinColumns = {
					@JoinColumn(name = "list_id")
			})
	private List<Days> lists;
	
	
	@ElementCollection
	@CollectionTable(
			name = "maps_tbl",
			joinColumns = {
					@JoinColumn(name = "map_id")
			})
	@MapKeyColumn(name = "key_id")
	@MapKeyEnumerated(EnumType.STRING)
	private Map<Days, String> maps;
	
	
	public enum Days{
		MON,TUE,WED,THUR,FRI,SAT,SUN;
	}
	
}









