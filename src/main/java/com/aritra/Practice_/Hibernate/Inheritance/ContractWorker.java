package com.aritra.Practice_.Hibernate.Inheritance;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
//@DiscriminatorValue("Contractual")
public class ContractWorker extends Worker{
	private float Wsalary_Contract;

	public float getWsalary_Contract() {
		return Wsalary_Contract;
	}

	public void setWsalary_Contract(float wsalary_Contract) {
		Wsalary_Contract = wsalary_Contract;
	}

	
}
