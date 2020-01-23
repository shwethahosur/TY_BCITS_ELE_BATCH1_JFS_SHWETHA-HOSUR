package com.bcits.springcore.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
//@AllArgsConstructor
@Data
public class EmployeeBean {
private String name ;
private int age;
private DepartmentBean departmentBean;
	/*
	 * public String getName() { return Name; } public void setName(String name) {
	 * Name = name; } public int getAge() { return age; } public void setAge(int
	 * age) { this.age = age; }
	 */

}
