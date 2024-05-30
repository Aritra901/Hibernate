package com.aritra.Practice_.Hibernate.Practice.practiceHibernate;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
@Entity
public class Section {
	@Id
	private int Section_id;
	private String Section_name;
	public int getSection_id() {
		return Section_id;
	}
	public void setSection_id(int section_id) {
		Section_id = section_id;
	}

	@OneToMany
	List<Student> Students = new ArrayList<Student>();
	public String getSection_name() {
		return Section_name;
	}
	public void setSection_name(String section_name) {
		Section_name = section_name;
	}
	public List<Student> getStudents() {
		return Students;
	}
	public void setStudents(List<Student> students) {
		Students = students;
	}
	// methods..
	
	public boolean insertIntoSection(Student std) {
		return this.Students.add(std);
	}
	
	public boolean deleteFromSection(Student std) {
		return this.Students.remove(std);
	}
}
