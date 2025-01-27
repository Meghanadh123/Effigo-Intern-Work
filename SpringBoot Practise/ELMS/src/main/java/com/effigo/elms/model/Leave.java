package com.effigo.elms.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="leavestatus_table")
public class Leave 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="sno")
	private int sno;
	@Column(name="empid")
	private int empid;
	@Column(name="empname",nullable=false,length=20)
	private String lname;
	@Column(name="leavetype",nullable=false,length=20)
	private String leavetype;
	@Column(name="fromdate",nullable=false,length=10)
	private String fromdate;
	@Column(name="enddate",nullable=false,length=10)
	private String todate;
	@Column(name="lstatus",nullable=false)
	  private boolean status;
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getLeavetype() {
		return leavetype;
	}
	public void setLeavetype(String leavetype) {
		this.leavetype = leavetype;
	}
	public String getFromdate() {
		return fromdate;
	}
	public void setFromdate(String fromdate) {
		this.fromdate = fromdate;
	}
	public String getTodate() {
		return todate;
	}
	public void setTodate(String todate) {
		this.todate = todate;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Leave [sno=" + sno + ", empid=" + empid + ", lname=" + lname + ", leavetype=" + leavetype
				+ ", fromdate=" + fromdate + ", todate=" + todate + ", status=" + status + "]";
	} 
	
	
}
