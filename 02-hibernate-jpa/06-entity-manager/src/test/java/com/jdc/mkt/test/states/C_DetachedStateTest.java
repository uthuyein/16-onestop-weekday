package com.jdc.mkt.test.states;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.jdc.mkt.entity.Teacher;
import com.jdc.mkt.test.JpaFactory;

public class C_DetachedStateTest extends JpaFactory{
	
	@Order(2)
	@ParameterizedTest
	@ValueSource(ints = {2})
	void clearTest(int id) {
		var em = emf.createEntityManager();
		
//		To be managed
		var teacher = em.find(Teacher.class, id);
		assertTrue(em.contains(teacher));

//		To be detached
		em.clear();
		assertFalse(em.contains(teacher));
		
		em.close();
	}
	

	@Order(1)
	@ParameterizedTest
	@ValueSource(ints = {2})
	void detachedTest(int id) {
		var em = emf.createEntityManager();
		
//		To be managed
		var teacher = em.find(Teacher.class, id);
		assertTrue(em.contains(teacher));

//		To be detached
		em.detach(teacher);
		assertFalse(em.contains(teacher));
		
		em.close();
	}
}
