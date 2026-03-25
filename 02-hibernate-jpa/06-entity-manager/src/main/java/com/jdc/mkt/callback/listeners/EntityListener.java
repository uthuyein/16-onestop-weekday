package com.jdc.mkt.callback.listeners;

import java.time.LocalDateTime;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

public class EntityListener {

	@PrePersist
	public void insert(Object obj) {
		if(obj instanceof EnableTimesListener entity) {
			Times times = entity.getTimes();
			if(null == times) {
				times = new Times();
				entity.setTimes(times);
			}
			times.setCreateDate(LocalDateTime.now());
		}
	}
	
	@PreUpdate
	public void update(Object obj) {
		if(obj instanceof EnableTimesListener entity) {
			Times times = entity.getTimes();
			if(null == times) {
				times = new Times();
				entity.setTimes(times);
			}
			times.setUpdateDate(LocalDateTime.now());
		}
	}
}
