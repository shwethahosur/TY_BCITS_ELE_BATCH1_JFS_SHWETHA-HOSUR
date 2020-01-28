package com.bcits.springrestjaxb.apptest;

import java.io.File;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.bcits.springrestjaxb.beans.EmployeeInfoBean;

public class EmployeeMarshalingTest {
public static void main(String[] args) {
	EmployeeInfoBean employeeInfoBean=new EmployeeInfoBean();
	employeeInfoBean.setEmpId(999);
	employeeInfoBean.setName("shwetha");
	employeeInfoBean.setMobileno(9799999999L);
	employeeInfoBean.setDateOfBirth(new Date());
	employeeInfoBean.setDateOfJoining(new Date());
	employeeInfoBean.setDesignation("ssd");
	employeeInfoBean.setSalary(50000);
	employeeInfoBean.setDeptId(225);
	employeeInfoBean.setPassword("shwetha");
	
JAXBContext context;
try {
	context = JAXBContext.newInstance(EmployeeInfoBean.class);
	Marshaller marshaller=context.createMarshaller();
	marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	marshaller.marshal(employeeInfoBean, System.out);
	marshaller.marshal(employeeInfoBean, new File("employeeInfo.xml"));
} catch (JAXBException e) {
	System.err.println("unable to marshall.....");
	e.printStackTrace();
}

}
}