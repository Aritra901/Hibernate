package com.aritra.Practice_.Hibernate.Practice;
enum Status{
	Running , Failled , Pending , Paused;
}
public class Practice_enum {
	public static void main(String[] args) {
		Status s = Status.Pending;
		System.out.println(s.ordinal());
		
	}
}
