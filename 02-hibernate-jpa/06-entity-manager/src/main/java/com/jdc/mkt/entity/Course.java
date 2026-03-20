package com.jdc.mkt.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NonNull
	private String name;
	private String description;
	
	/*
	 * Using OrphanRemoval
	 * 1.without parent,without child
	 * 2.will delete in db ,if doen't wanted from parent.
	 */
	@OneToMany(mappedBy = "course",cascade = CascadeType.REMOVE)
	private List<Student> students;
}
