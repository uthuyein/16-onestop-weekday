package com.jdc.mkt.test.states;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.jdc.mkt.entity.Course;
import com.jdc.mkt.entity.Student;
import com.jdc.mkt.test.JpaFactory;

import jakarta.persistence.EntityNotFoundException;

public class B_ManageStateTest extends JpaFactory{
	/*
	 * 1.if found Id 
	 * 					  find			getReference
	 * ii.Return Value => entity		proxy obj
	 * 
	 * 2.if not found Id
	 * ii.Return Value => null		    proxy obj
	 */
	
	@Order(3)
	@ParameterizedTest
	@CsvSource("Michael bannett,5")
	void findWithNotFoundIdTest(String loginId,int id) {
		var em = emf.createEntityManager();
	
		var ref = em.getReference(Student.class, id);
		assertThrows(EntityNotFoundException.class,() -> ref.getLoginId());
		
		var fi = em.find(Student.class, id);
		assertThrows(NullPointerException.class,() -> fi.getLoginId());
		
		
		em.close();
	}
	
	@Order(2)
	@ParameterizedTest
	@CsvSource("Michael Bannett,1")
	void findWithFoundIdTest(String loginId,int id) {
		var em = emf.createEntityManager();
 		var student = em.find(Student.class, id); //or getReference
		assertTrue(em.contains(student));
		assertEquals("Java Basic", student.getCourse().getName());
		assertEquals(loginId, student.getLoginId());
		em.close();
	}

	@Order(1)
	@ParameterizedTest
	@CsvSource("David,123")
	void persistTest(String loginId,String password) {
		var student = new Student(loginId,password);
		var course = new Course("Python");
		student.setCourse(course);
		
		var em = emf.createEntityManager();
		em.getTransaction().begin();
//		em.persist(course);
		em.persist(student);
		assertTrue(em.contains(student));
		em.getTransaction().commit();
		em.close();
	}
}
