package com.bcits.bean;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//import com.bcits.jpawithhibernateapp1.manytomany.ProjectInfo;

import lombok.Data;
import lombok.ToString.Exclude;
@Data
@Entity
@Table(name="employee_primary_info")
public class Test1 implements Serializable {
	@Id
	@Column
	private int empid;
	
	@Column(name="name")
	private  String empname;
	
	@Column(name="phno")
	private long empphno;
	
	@Column(name="official_mail_id")
	private String empofficial_mail_id;
	
	@Column(name="date_of_birth")
	private Date empdate_of_birth;
	
	@Column(name="date_of_joining")
	private Date empdate_of_joining;
	
	@Column(name="designation")
	private String empdesignation;
	
	@Column(name="blood_group")
	private String empblood_group;
	
	@Column(name="salary")
	private double empsalary;
	
	@Column(name="deptid")
	private int empdeptid;
	
	@Column(name="manager_id")
	private int empmanager_id;
	
	@Column
	private String password;
//	@Exclude
//@OneToOne(cascade=CascadeType.ALL,mappedBy="test1")//bidirectional flow
//	private Secondaryinfo secondaryinfo;
	
//@ManyToMany(cascade=CascadeType.ALL,mappedBy="test1")
//private List <ProjectInfo>prolist;
	
	
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public long getEmpphno() {
		return empphno;
	}
	public void setEmpphno(long empphno) {
		this.empphno = empphno;
	}
	public String getEmpofficial_mail_id() {
		return empofficial_mail_id;
	}
	public void setEmpofficial_mail_id(String empofficial_mail_id) {
		this.empofficial_mail_id = empofficial_mail_id;
	}
	public Date getEmpdate_of_birth() {
		return empdate_of_birth;
	}
	public void setEmpdate_of_birth(Date empdate_of_birth) {
		this.empdate_of_birth = empdate_of_birth;
	}
	public Date getEmpdate_of_joining() {
		return empdate_of_joining;
	}
	public void setEmpdate_of_joining(Date empdate_of_joining) {
		this.empdate_of_joining = empdate_of_joining;
	}
	public String getEmpdesignation() {
		return empdesignation;
	}
	public void setEmpdesignation(String empdesignation) {
		this.empdesignation = empdesignation;
	}
	public String getEmpblood_group() {
		return empblood_group;
	}
	public void setEmpblood_group(String empblood_group) {
		this.empblood_group = empblood_group;
	}
	public double getEmpsalary() {
		return empsalary;
	}
	public void setEmpsalary(double empsalary) {
		this.empsalary = empsalary;
	}
	public int getEmpdeptid() {
		return empdeptid;
	}
	public void setEmpdeptid(int empdeptid) {
		this.empdeptid = empdeptid;
	}
	public int getEmpmanager_id() {
		return empmanager_id;
	}
	public void setEmpmanager_id(int empmanager_id) {
		this.empmanager_id = empmanager_id;
	}

}
