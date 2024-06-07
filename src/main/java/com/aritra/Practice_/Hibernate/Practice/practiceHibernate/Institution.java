package com.aritra.Practice_.Hibernate.Practice.practiceHibernate;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Institution {
	@Id 
	private int Insti_id;
	private String Insti_name;
	@ManyToMany(mappedBy = "institute" , cascade = CascadeType.ALL)
	List<Class> Classes = new ArrayList<Class>();
	public int getInsti_id() {
		return Insti_id;
	}
	public void setInsti_id(int insti_id) {
		Insti_id = insti_id;
	}
	public String getInsti_name() {
		return Insti_name;
	}
	public void setInsti_name(String insti_name) {
		Insti_name = insti_name;
	}
	public List<Class> getClasses() {
		return Classes;
	}
	public void setClasses(List<Class> classes) {
		Classes = classes;
	}
	
	//methods...
	
	public boolean insertIntoInstitution(Class cl ) {
		return this.Classes.add(cl);
	}
	
	public boolean deleteFromInstitution(Class cl ) {
		return this.Classes.remove(cl);
	}
	
	

}
