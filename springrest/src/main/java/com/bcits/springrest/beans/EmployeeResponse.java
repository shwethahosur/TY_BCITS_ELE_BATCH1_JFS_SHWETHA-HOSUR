package com.bcits.springrest.beans;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@Data
@JsonPropertyOrder({ "statusCode", "message", "description" })
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeResponse {
	private int statusCode;
	private String message;
	private String description;
	@JsonProperty("employeeInfo")
	private EmployeeInfoBean employeeInfoBean;
	private List<EmployeeInfoBean> employeeList;
}
