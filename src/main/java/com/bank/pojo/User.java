package com.bank.pojo;

import org.springframework.stereotype.Component;

@Component
public class User {
	private int accno;
	private String uname;
	private String location;
	private double balance;
	private String mobile;
	private int bankid;
	public User() {
		
	}
	public User(int accno, String uname, String location, double balance, String mobile, int bankid) {
		this.accno = accno;
		this.uname = uname;
		this.location = location;
		this.balance = balance;
		this.mobile = mobile;
		this.bankid = bankid;
	}
	public int getAccno() {
		return accno;
	}
	public void setAccno(int accno) {
		this.accno = accno;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public int getBankid() {
		return bankid;
	}
	public void setBankid(int bankid) {
		this.bankid = bankid;
	}
	@Override
	public String toString() {
		return String.format("%-10s %-15s %-15s %-15s %-15s %-15s", this.getAccno(),this.getUname(),this.getLocation(),this.getBalance(),this.getMobile(),this.getBankid());
	}
	
}
