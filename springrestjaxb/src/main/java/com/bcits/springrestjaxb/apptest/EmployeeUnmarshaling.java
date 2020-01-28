package com.bcits.springrestjaxb.apptest;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.bcits.springrestjaxb.beans.EmployeeInfoBean;

public class EmployeeUnmarshaling {
public static void main(String[] args) {
	JAXBContext jaxbContext;
	try {
		jaxbContext=JAXBContext.newInstance(EmployeeInfoBean.class);
		Unmarshaller unmarshaller=jaxbContext.createUnmarshaller();
		EmployeeInfoBean employeeInfoBean=(EmployeeInfoBean)unmarshaller.unmarshal(new File("employeeinfo2.xml"));
	
		System.out.println("name:"+employeeInfoBean.getName());
		System.out.println("empid:"+employeeInfoBean.getEmpId());
		
		
	} catch (JAXBException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}