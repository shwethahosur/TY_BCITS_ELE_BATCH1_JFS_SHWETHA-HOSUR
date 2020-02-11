package com.bcits.usecase.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "Employee_master")
public class EmployeeMaster implements Serializable {
	@Id
	@Column
	private Integer empId;
	@Column
	private String empName;
	@Column
	private String password;
	@Column
	private String region;
	@Column
	private String designation;
}
