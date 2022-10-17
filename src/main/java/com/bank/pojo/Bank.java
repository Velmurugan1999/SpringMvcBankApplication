package com.bank.pojo;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Bank {
	private int bid;
	private String bname;
	private String city;
	private String ifsc;
	private List<User> user;
	public Bank() {
		
	}
	
	public Bank(int bid, String bname, String city, String ifsc) {
		super();
		this.bid = bid;
		this.bname = bname;
		this.city = city;
		this.ifsc = ifsc;
	}

	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getIfsc() {
		return ifsc;
	}
	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}

	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return String.format("%-5s %-15s %-15s %-15s", this.getBid(),this.getBname(),this.getCity(),this.getIfsc());//+this.getUser().toString();
	}
}
