package com.aritra.Practice_.Hibernate.Practice.practiceHibernate;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
@Entity
public class Class {
	@Id
	private int Class_id;
	private String Class_name;
	@ManyToMany
	List<Section> Department = new ArrayList<Section>();
	public List<Section> getDepartment() {
		return Department;
	}
	public void setDepartment(List<Section> department) {
		Department = department;
	}
	public List<Institution> getInstitute() {
		return institute;
	}
	public void setInstitute(List<Institution> insti) {
		this.institute = insti;
	}

	@ManyToMany
	List<Institution> institute = new ArrayList<Institution>();
	
	public int getClass_id() {
		return Class_id;
	}
	public void setClass_id(int class_id) {
		Class_id = class_id;
	}
	public String getClass_name() {
		return Class_name;
	}
	public void setClass_name(String class_name) {
		Class_name = class_name;
	}
	public List<Section> getClasses() {
		return Department;
	}
	public void setClasses(List<Section> department) {
		Department = department;
	}
	
	//methods..
	
	public boolean inserIntoClass(Section sec) {
		return this.Department.add(sec);
	}
	
	public boolean deleteFromClass(Section sec) {
		return this.Department.remove(sec);
	}
	
}
