package com.jdc.mkt.test;

import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import com.jdc.mkt.entity.Category;
import com.jdc.mkt.entity.Medicine;

import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

public class A_Query_Vs_TypeQuery extends JpaFactory{

	@Test
	@Order(1)
//	raw type,it will become runtime exception
	void queryTest() {
		var em = emf.createEntityManager();
		Query query = em.createQuery("select c from Category c");
		List<Medicine> list = query.getResultList();		// Not Medicine type
		System.out.println(list);
	}
	
	@Test
	@Order(2)
	void typedQueryTest() {
		var em = emf.createEntityManager();
		TypedQuery<Category> query = em.createQuery("select c from Category c",Category.class);
		List<Category> list = query.getResultList();		
		System.out.println(list);
	}
}
