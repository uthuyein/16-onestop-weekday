package com.jdc.mkt.test.states;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import com.jdc.mkt.entity.Teacher;
import com.jdc.mkt.test.JpaFactory;

public class A_StateTest extends JpaFactory{


	@Test
	@Order(3)
	void testRemovedState() {
		var em = emf.createEntityManager();

		/*	To Be Managed State */
		var teacher = em.find(Teacher.class, 1);
		assertTrue(em.contains(teacher));

		em.getTransaction().begin();

		/* To Be REMOVED State */
		em.remove(teacher);
		assertFalse(em.contains(teacher));

		em.getTransaction().commit();

	}

	@Test
	@Order(2)
	void testDetachedState() {
		var em = emf.createEntityManager();

		/* To Be Managed State */
		var teacher = em.find(Teacher.class, 1);
		assertTrue(em.contains(teacher));

		/* To Be DETACHED State */
		em.detach(teacher);
		assertFalse(em.contains(teacher));
	}

	@Test
	@Order(1)	
	void testManageState() {
		var em = emf.createEntityManager();

		/* To Be TRANSIENT State */
		var teacher = new Teacher("admin","123");
		teacher.setTeaching("Java");

		assertFalse(em.contains(teacher));

		em.getTransaction().begin();

		/* To Be Managed State */
		em.persist(teacher);
		assertTrue(em.contains(teacher));

		em.getTransaction().commit();
		em.close();

	}
}
