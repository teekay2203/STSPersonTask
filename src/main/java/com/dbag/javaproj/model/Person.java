package com.dbag.javaproj.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Persondb")
public class Person 
{
	@Id
	@Column(name = "Id")
	private long id;
	
	@Column(name = "FirstName")
	private String firstName;
	
	@Column(name = "LastName")
	private String lastName;
	
	@Column(name = "LoctionOfc")
	private String ofcLocation;
	
	@Column(name = "Department")
	private String compDept;
	
	@Column(name = "ProjectWorking")
	private String projWorking;
	
	@Column(name = "SSNID")
	private long socialSecNumber;
	
	
	
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Person(String firstName, String lastName, String ofcLocation, String compDept, String projWorking,
			long socialSecNumber) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.ofcLocation = ofcLocation;
		this.compDept = compDept;
		this.projWorking = projWorking;
		this.socialSecNumber = socialSecNumber;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getOfcLocation() {
		return ofcLocation;
	}
	public void setOfcLocation(String ofcLocation) {
		this.ofcLocation = ofcLocation;
	}
	public String getCompDept() {
		return compDept;
	}
	public void setCompDept(String compDept) {
		this.compDept = compDept;
	}
	public String getProjWorking() {
		return projWorking;
	}
	public void setProjWorking(String projWorking) {
		this.projWorking = projWorking;
	}
	public long getSocialSecNumber() {
		return socialSecNumber;
	}
	public void setSocialSecNumber(long socialSecNumber) {
		this.socialSecNumber = socialSecNumber;
	}
	
	
}
