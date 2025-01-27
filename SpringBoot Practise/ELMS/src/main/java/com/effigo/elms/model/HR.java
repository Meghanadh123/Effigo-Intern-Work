package com.effigo.elms.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "hr_table")
public class HR {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="hr_id")
	private int id;
	@Column(name="hr_name",nullable=false,length = 50)
	private String name;
	@Column(name="hr_gender",length = 10)
	private String gender;
	@Column(name="hr_dob",nullable=false,length = 20)
	private String dateofbirth;
	@Column(name="hr_salary",nullable=false)
	private double salary;
	@Column(name="hr_email",nullable=false,unique = true,length = 30)
	private String email;
	@Column(name="hr_password",nullable=false,length = 30)
	private String password;
	@Column(name="hr_location",nullable=false)
	private String location;
	@Column(name="hr_contact",nullable=false,unique = true)
	private String contact;
	@Column(name="hr_active",nullable=false)
	private boolean active; // true or false
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDateofbirth() {
		return dateofbirth;
	}
	public void setDateofbirth(String dateofbirth) {
		this.dateofbirth = dateofbirth;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	@Override
	public String toString() {
		return "HR [id=" + id + ", name=" + name + ", gender=" + gender + ", dateofbirth=" + dateofbirth
				+ ", salary=" + salary + ", email=" + email + ", password=" + password
				+ ", location=" + location + ", contact=" + contact + ", active=" + active + "]";
	}
}
