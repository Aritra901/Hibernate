package com.aritra.Practice_.Hibernate.Practice.practiceHibernate;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Institution {
	@Id 
	private int Insti_di;
	private String Insti_name;
	@ManyToMany(mappedBy = "institute")
	List<Class> Classes = new ArrayList<Class>();
	public int getInsti_di() {
		return Insti_di;
	}
	public void setInsti_di(int insti_di) {
		Insti_di = insti_di;
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
