package com.jdc.mkt.test;

import org.junit.jupiter.api.Test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaFactory {

	EntityManagerFactory emf;
	EntityManager em;
	
	@Test
	void test() {
		emf = Persistence.createEntityManagerFactory("collection-mappings");
	}
}
