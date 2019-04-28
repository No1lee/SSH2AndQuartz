package com.rj.bd.framework.entity;

import java.util.Date;

/**
 * Student entity. @author MyEclipse Persistence Tools
 */

@SuppressWarnings("serial")
public class Student implements java.io.Serializable {

	// Fields

	private String sid;
	private String name;
	private String sex;
	private Date bir;
	private String email;
	// Constructors

	/** default constructor */
	public Student() {
	}

	/** minimal constructor */
	public Student(String sid) {
		this.sid = sid;
	}

	

	// Property accessors

	public Student(String sid, String name, String sex, Date bir, String email) {
		super();
		this.sid = sid;
		this.name = name;
		this.sex = sex;
		this.bir = bir;
		this.email = email;
	}

	public Date getBir() {
		return bir;
	}

	public void setBir(Date bir) {
		this.bir = bir;
	}

	public String getSid() {
		return this.sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", name=" + name + ", sex=" + sex + ", bir=" + bir + ", email=" + email + "]";
	}


	

}