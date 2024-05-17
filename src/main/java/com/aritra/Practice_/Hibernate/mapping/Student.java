package com.aritra.Practice_.Hibernate.mapping;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
//import jakarta.validation.constraints.AssertFalse.List;

@Entity
public class Student {
	@Override
	public String toString() {
		return "Student [Sid=" + Sid + ", Sname=" + Sname + ", lap=" + lap + "]";
	}
	@Id
	@Column(name="student_id")
	private int Sid;
	@Column(name="student_name")
	private String Sname;
	
//	private Laptop lap;
	@ManyToMany(mappedBy = "std")
	private List<Laptop> lap = new ArrayList<Laptop>();
	public List<Laptop> getLap() {
		return lap;
	}
	public void setLap(List<Laptop> lap) {
		this.lap = lap;
	}
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(columnDefinition = "id")

	public int getSid() {
		return Sid;
	}
	public void setSid(int sid) {
		Sid = sid;
	}
	public String getSname() {
		return Sname;
	}
	public void setSname(String sname) {
		Sname = sname;
	}
	
}
