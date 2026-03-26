package com.jdc.mkt.test;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.jdc.mkt.entity.Employee;
import com.jdc.mkt.entity.Employee.Role;
import com.jdc.mkt.entity.Medicine;

public class D_Select_With_Param extends JpaFactory{
	
	/*
	 * select m.name from medicine_tbl where m.label_price = 
	 * (select min(label_price) from medicine_tbl)
	 */
	@Test
	@Order(5)
	void selectMedicineWithNestedQuery() {
		var query = em.createQuery("""
				select m.name from Medicine m where m.labelPrice = (
					select min(m.labelPrice) from Medicine m
				)
				""",String.class);
		var list = query.getSingleResult();
		System.out.println(list);
	}
	
	/*
	 * select * from employee_tbl emp where emp.role in ('CASHIER','MANAGER')
	 */
	@Test
	@Order(4)
	void selectEmployeeWithInOpe() {
		var query = em.createQuery("select emp from Employee emp where emp.role in (:one,:two)",Employee.class);
		query.setParameter("one", Role.CASHIER);
		query.setParameter("two", Role.MANAGER);
		var list = query.getResultList();
		System.out.println(list);
	}
	/*
	 * select * from medicine_tbl m where lower(m.name) like lower('m%')
	 */
	@Order(3)
	@ParameterizedTest
	@ValueSource(strings = {"m","p"})
	void selectMedicineNamelike(String name) {
		var query = em.createQuery("select m from Medicine m where lower(m.name) like :name",Medicine.class);
		query.setParameter("name", name.concat("%").toLowerCase());
		var list = query.getResultList();
		System.out.println(list);
	}
	
	@Test
	@Order(2)
	/*
	 * select * from medicine_tbl where label_price between ? and ?
	 */
	void selectAllMedicinePriceBetWithNameParam() {
		var query = em.createQuery("select m from Medicine m where m.labelPrice between :from and :to ",Medicine.class);
		query.setParameter("from", 5);
		query.setParameter("to", 10);
		var list = query.getResultList();
		System.out.println(list);
		
	}
	
	@Test
	@Order(1)
	/*
	 * select * from employee_tbl where role = ? and is_active = true
	 */
	void selectAllCashierWithIndexParam() {
		var query = em.createQuery("select emp from Employee emp where emp.role = ?1",Employee.class);
		query.setParameter(1, Role.CASHIER);
		var list = query.getResultList();
		System.out.println(list);
		
	}

}
