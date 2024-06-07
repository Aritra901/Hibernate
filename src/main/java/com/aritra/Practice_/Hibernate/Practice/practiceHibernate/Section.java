package com.aritra.Practice_.Hibernate.Practice.practiceHibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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
	@ManyToMany
	List<Class> class_in = new ArrayList<Class>();
	public List<Class> getClass_in() {
		return class_in;
	}
	public void setClass_in(List<Class> class_in) {
		this.class_in = class_in;
	}
	@OneToMany( mappedBy = "sec" , cascade = CascadeType.ALL )
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
