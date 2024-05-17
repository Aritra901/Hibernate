package com.aritra.Practice_.Hibernate.Inheritance;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
//@DiscriminatorValue("Regular")
public class RegularWorker extends Worker{
	private double Wsalary_Regular;

	public double getWsalary_Regular() {
		return Wsalary_Regular;
	}

	public void setWsalary_Regular(double wsalary_Regular) {
		Wsalary_Regular = wsalary_Regular;
	}
	
}
