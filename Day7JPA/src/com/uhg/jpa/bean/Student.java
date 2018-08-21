package com.uhg.jpa.bean;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the student database table.
 * 
 */
@Entity
@NamedQuery(name="Student.findAll", query="SELECT s FROM Student s")
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int stuid;

	@Column(name="class")
	private int class_;

	private String email;

	private long mobile;

	private String stuname;

	public Student() {
	}

	public int getStuid() {
		return this.stuid;
	}

	public void setStuid(int stuid) {
		this.stuid = stuid;
	}

	public int getClass_() {
		return this.class_;
	}

	public void setClass_(int class_) {
		this.class_ = class_;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getMobile() {
		return this.mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public String getStuname() {
		return this.stuname;
	}

	public void setStuname(String stuname) {
		this.stuname = stuname;
	}

}