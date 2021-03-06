package com.example.demo.otherClass;

import org.springframework.stereotype.Component;

@Component
public class Alien {
	
	private int id;
	private String first_name;
	private String last_name;
	private String address;
	public Alien() {
		super();
		System.out.println("Alien constructor");
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void show() {
		System.out.println("Entered in Alien");
	}
	@Override
	public String toString() {
		return "Alien [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", address=" + address
				+ "]";
	}
}
