package com.jdc.mkt.test;

import org.junit.jupiter.api.Test;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaFactory {

	EntityManagerFactory emf;
	
	@Test
	void test() {
		emf = Persistence.createEntityManagerFactory("relation-mappings");
	}
}
