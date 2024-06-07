package com.aritra.Practice_.Hibernate.Practice.practiceHibernate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Student {
	@Id
	private int Std_id;
	private String Std_name;
	private int Std_age;
	private int StdClass_id;
	public int getStdClass_id() {
		return StdClass_id;
	}
	@Override
	public String toString() {
		return "Student [Std_id=" + Std_id + ", Std_name=" + Std_name + ", Std_age=" + Std_age + ", StdClass_id="
				+ StdClass_id + ", sec=" + sec + "]";
	}
	public void setStdClass_id(int stdClass_id) {
		StdClass_id = stdClass_id;
	}
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
	public int getStd_age() {
		return Std_age;
	}
	public void setStd_age(int i) {
		Std_age = i;
	}
	
}
