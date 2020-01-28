package com.bcits.springrestjaxb.jsontest;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;

import com.bcits.springrestjaxb.beans.EmployeeInfoBean;

public class EmployeeJSONUnmarshalling {
public static void main(String[] args) {
	
	
	try {
		
		ObjectMapper objectMapper=new ObjectMapper();
		EmployeeInfoBean employeeInfoBean=objectMapper.readValue(new File("empjson2.json"), EmployeeInfoBean.class);
		System.out.println("id:"+employeeInfoBean.getEmpId());
		System.out.println("name:"+employeeInfoBean.getName());
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}
