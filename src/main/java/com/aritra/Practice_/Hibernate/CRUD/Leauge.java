package com.aritra.Practice_.Hibernate.CRUD;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
@Entity
public class Leauge {
	@Id
	private int leauge_id;
	private String leauge_name;
	@OneToMany(mappedBy = "leauge")
	List<Player> players = new ArrayList<Player>();
	public int getLeauge_id() {
		return leauge_id;
	}
	public void setLeauge_id(int leauge_id) {
		this.leauge_id = leauge_id;
	}
	public String getLeauge_name() {
		return leauge_name;
	}
	public void setLeauge_name(String leauge_name) {
		this.leauge_name = leauge_name;
	}
	public List<Player> getPlayers() {
		return players;
	}
	public void setPlayers(List<Player> players) {
		this.players = players;
	}
	
	
	
	
}

