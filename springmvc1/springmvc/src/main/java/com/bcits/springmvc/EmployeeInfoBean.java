package com.bcits.springmvc1.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="employee_primary_info")
public class EmployeeInfoBean  implements Serializable{
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
}
