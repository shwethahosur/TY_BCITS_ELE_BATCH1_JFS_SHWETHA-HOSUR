package com.bcits.springcore.beans;

import lombok.Data;

@Data
public class EmployeeBean {
private String Name ;
private int age;
private DepartmentBean departmentBean;
	/*
	 * public String getName() { return Name; } public void setName(String name) {
	 * Name = name; } public int getAge() { return age; } public void setAge(int
	 * age) { this.age = age; }
	 */

}
