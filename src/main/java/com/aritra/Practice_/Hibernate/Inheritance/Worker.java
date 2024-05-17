package com.aritra.Practice_.Hibernate.Inheritance;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@DiscriminatorColumn(
//		name="Employee Type",
//		discriminatorType = DiscriminatorType.STRING
//)
public class Worker {
	@Id
	@GeneratedValue
	private int Wid;
	private String Wname;
	public int getWid() {
		return Wid;
	}
	public void setWid(int wid) {
		Wid = wid;
	}
	public String getWname() {
		return Wname;
	}
	public void setWname(String wname) {
		Wname = wname;
	}
	
}
