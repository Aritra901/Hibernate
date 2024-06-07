package com.aritra.Practice_.Hibernate.CRUD;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;

@Entity
@NamedQuery(name = "UserDetails.byId" , query = "select User_name from UserDetails where User_id > :Userid")
public class UserDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int User_id;

	private String User_name;
	public int getUser_id() {
		return User_id;
	}
	public void setUser_id(int user_id) {
		User_id = user_id;
	}
	public String getUser_name() {
		return User_name;
	}
	public void setUser_name(String user_name) {
		User_name = user_name;
	}
	@Override
	public String toString() {
		return "UserDetails [User_id=" + User_id + ", User_name=" + User_name + "]";
	}

	
}
