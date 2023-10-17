package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UserPage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long studentid;
	private String studentname;
	private String branch;
	private long yearofjoining;
	private String query;
	public long getStudentid() {
		return studentid;
	}
	public void setStudentid(long studentid) {
		this.studentid = studentid;
	}
	public String getStudentname() {
		return studentname;
	}
	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public long getYearofjoining() {
		return yearofjoining;
	}
	public void setYearofjoining(long yearofjoining) {
		this.yearofjoining = yearofjoining;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
}
