package com.jdc.mkt.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.jdc.mkt.entity.Teacher;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

@TestMethodOrder(OrderAnnotation.class)
public class JpaFactory {

	static EntityManagerFactory emf;

	@BeforeAll
	static void init() {
		emf = Persistence.createEntityManagerFactory("entity-manager");
	}

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
		var teacher = new Teacher();
		teacher.setLoginId("admin");
		teacher.setPassword("123");
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
