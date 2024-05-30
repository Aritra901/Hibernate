package com.aritra.Practice_.Hibernate.Practice.practiceHibernate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Student {
	@Id
	private int Std_id;
	private String Std_name;
	private String Std_age;
	@ManyToOne
	private Section sec;
	public Section getSec() {
		return sec;
	}
	public void setSec(Section sec) {
		this.sec = sec;
	}
	public int getStd_id() {
		return Std_id;
	}
	public void setStd_id(int std_id) {
		Std_id = std_id;
	}
	public String getStd_name() {
		return Std_name;
	}
	public void setStd_name(String std_name) {
		Std_name = std_name;
	}
	public String getStd_age() {
		return Std_age;
	}
	public void setStd_age(String std_age) {
		Std_age = std_age;
	}
	
}
