package com.jdc.mkt.test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.jdc.mkt.entity.Course;
import com.jdc.mkt.entity.Student;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaFactory {

	static EntityManagerFactory emf;
	
	@BeforeAll
	static void init() {
		emf = Persistence.createEntityManagerFactory("inheritance-mappings");
	}
	
	@Test
	void test() {
		var em = emf.createEntityManager();
		Student acc1 = new Student();
//		acc1.setId(UUID.randomUUID());
		acc1.setLoginId("test@gmail.com");
		acc1.setPassword("123");
		
		var course = new Course();
		course.setName("Core Java");
		course.setDescription("This is about java basic.");
		
		acc1.setCourse(course);
		
		em.getTransaction().begin();
		em.persist(course);
		em.persist(acc1);
		em.getTransaction().commit();
		
	}
}
