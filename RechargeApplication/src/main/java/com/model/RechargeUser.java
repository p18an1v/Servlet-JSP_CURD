package com.model;

import java.util.Date;

public class RechargeUser {

	private String name;
	private String mobno;
	private String operator;
	private String state;
	private Date date;
	private String plan;
	
	
	public RechargeUser(String name, String mobno, String operator, String state, Date date, String plan) {
		super();
		name = name;
		this.mobno = mobno;
		this.operator = operator;
		this.state = state;
		this.date = date;
		this.plan = plan;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		name = name;
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getPlan() {
		return plan;
	}
	public void setPlan(String plan) {
		this.plan = plan;
	}
	
	
}
