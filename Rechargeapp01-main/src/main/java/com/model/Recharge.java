package com.model;

import java.util.Date;

public class Recharge {
	private String name;
	private String mobno;
	private String operator;
	private String state;
	private String date;
	private String plan;
	
	public Recharge(String name,String mobno, String state,String date,String plan, String operator) {
		super();
		this.mobno = mobno;
		this.operator = operator;
		this.state = state;
		this.name = name;
		this.date = date;
		this.plan=plan;
	}
	public String getMobno() {
		return mobno;
	}
	public void setMobno(String mobno) {
		this.mobno = mobno;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	public String getPlan() {
		return plan;
	}
	
	public void setPlan(String plan) {
		this.plan = plan;
	}
	
}
