package com.jdc.mkt.test.states;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.jdc.mkt.entity.Course;
import com.jdc.mkt.test.JpaFactory;

public class D_RemoveStateTest extends JpaFactory{
	

	@ParameterizedTest
	@ValueSource(ints = {1})
	void removeTest(int id) {
		var em = emf.createEntityManager();
		
//		To be managed state
		var course = em.find(Course.class, id);
		assertTrue(em.contains(course));
		em.getTransaction().begin();
		
//		var list = course.getStudents();
//		
//		if(null != list) {
//			list.remove(1);
//		}
		
//		To be removed state
		em.remove(course);
		em.getTransaction().commit();
		
		em.close();
	}
}
