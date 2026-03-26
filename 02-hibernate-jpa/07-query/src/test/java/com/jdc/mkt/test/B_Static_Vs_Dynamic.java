package com.jdc.mkt.test;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import com.jdc.mkt.entity.Medicine;

public class B_Static_Vs_Dynamic extends JpaFactory{

	@Test
	@Order(1)
	void dynamicTest() {
		var em = emf.createEntityManager();
		var query = em.createQuery("select m from Medicine m",Medicine.class);
		var list = query.getResultList();
		System.out.println(list);
	}
	
	@Test
	@Order(2)
	void staticTest() {
		var em = emf.createEntityManager();
		var query = em.createNamedQuery("Medicine.findAll",Medicine.class);
		var list = query.getResultList();
		System.out.println(list);
	}
	
}
