package com.jdc.mkt.test;

import org.junit.jupiter.api.Test;

import com.jdc.mkt.entity.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaFactory {

	EntityManagerFactory emf;
	EntityManager em;
	
	@Test
	void test() {
		emf = Persistence.createEntityManagerFactory("class-and-field-mappings");
//		em = emf.createEntityManager();
//		
//		var user = new User();
//		user.setName("Andrew");
//		user.setAge(20);
//		
//		em.getTransaction().begin();
//		em.persist(user);
//		em.getTransaction().commit();
	}
}
