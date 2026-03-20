package com.jdc.mkt.test.stateChange;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.jdc.mkt.entity.Teacher;
import com.jdc.mkt.test.JpaFactory;

public class C_RemoveTest extends JpaFactory{

	@Test
	void removeTest() {
		var em = emf.createEntityManager();
		em.getTransaction().begin();
		
//		To be managed
		var teacher = em.find(Teacher.class, 2);
		assertTrue(em.contains(teacher));
		
//		To removed
		em.remove(teacher);
		assertFalse(em.contains(teacher));
		
//		To be managed
		em.persist(teacher);
		assertTrue(em.contains(teacher));
		
//		To be detached
		em.clear();
		assertThrows(IllegalArgumentException.class, () -> em.remove(teacher));
		
		em.getTransaction().commit();
		em.close();
	}
	
	
}
