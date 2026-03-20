package com.jdc.mkt.test.stateChange;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.jdc.mkt.entity.Staff;
import com.jdc.mkt.test.JpaFactory;

import jakarta.persistence.PersistenceException;

public class A_PersitTest extends JpaFactory{

	@Test
	void persistTest() {
		var em = emf.createEntityManager();
		
//		To be transient
		var staff = new Staff("George", "G123");
		staff.addInfo("check attendance","collect payment");
		
		em.getTransaction().begin();
			
//		To be managed
		em.persist(staff);
		assertTrue(em.contains(staff));
		
//		To be removed
		em.remove(staff);
		assertFalse(em.contains(staff));
		
		
//		To be managed
		em.persist(staff);
		assertTrue(em.contains(staff));
		
//		To be detached
		em.detach(staff);
		assertFalse(em.contains(staff));
		assertThrows(PersistenceException.class, () -> em.persist(staff));
		
		em.getTransaction().commit();
		em.close();
		
	}
}
