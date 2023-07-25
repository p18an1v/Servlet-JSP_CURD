package com.model;

public class Register {
	
	private String name;
	private String mobno;
	private String gmail;
	private String city;
	private String password;
	public Register(String name, String mobno, String gmail, String city, String password) {
		super();
		this.name = name;
		this.mobno = mobno;
		this.gmail = gmail;
		this.city = city;
		this.password = password;
	}
	public Register() {
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobno() {
		return mobno;
	}
	public void setMobno(String mobno) {
		this.mobno = mobno;
	}
	public String getGmail() {
		return gmail;
	}
	public void setGmail(String gmail) {
		this.gmail = gmail;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	}
	
