package com.bcits.springrestjaxb.jsontest;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.bcits.springrestjaxb.beans.EmployeeInfoBean;

public class EmployeeJSONMarshalling {
	public static void main(String[] args) {
		EmployeeInfoBean employeeInfoBean = new EmployeeInfoBean();
		employeeInfoBean.setEmpId(999);
		employeeInfoBean.setName("shwetha");
		employeeInfoBean.setMobileno(9799999999L);
		employeeInfoBean.setDateOfBirth(new Date());
		employeeInfoBean.setDateOfJoining(new Date());
		employeeInfoBean.setDesignation("ssd");
		employeeInfoBean.setSalary(50000);
		employeeInfoBean.setDeptId(225);
		employeeInfoBean.setPassword("shwetha");
//		employeeInfoBean.setOfficialMail("shwetha@gmail.com");

		// marshalling into json

		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.writerWithDefaultPrettyPrinter();// formatting
			mapper.writeValue(new File("empjson4.json"), employeeInfoBean);
			mapper.writeValue(System.out, employeeInfoBean);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}