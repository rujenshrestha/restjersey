package com.sresta.restjersey.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Student{
	
	private String uId;
	private String firstName;
	private String middleName;
	private String lastName;
	private String gender;
	private String deptId;
	private String level;
	private String degId;
	
	public Student(){}
	
	public String getuId() {
		return uId;
	}
	public void setuId(String uId) {
		this.uId = uId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getDegId() {
		return degId;
	}
	public void setDegId(String degId) {
		this.degId = degId;
	}
	@Override
	public String toString() {
		return "Student [uId=" + uId + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName="
				+ lastName + ", gender=" + gender + ", deptId=" + deptId + ", level=" + level + ", degId=" + degId
				+ "]";
	}
	
	
	

}
