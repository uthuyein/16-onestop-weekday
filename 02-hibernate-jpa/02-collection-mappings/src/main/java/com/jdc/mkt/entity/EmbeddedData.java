package com.jdc.mkt.entity;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class EmbeddedData {

	private String value;
	
//	@ElementCollection
//	private List<String> datas;
}
