package com.bcits.springrestjaxb.apptest;

import java.io.File;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.codehaus.jackson.map.ObjectMapper;

import com.bcits.springrestjaxb.beans.EmployeeInfoBean;
import com.bcits.springrestjaxb.beans.UserInfoBean;
import com.bcits.springrestjaxb.beans.UserInfoBean;

public class UserUnmarshaling {
	public static void main(String[] args) {
//		JAXBContext jaxbContext;
//		try {
//			jaxbContext=JAXBContext.newInstance(UserInfoBean.class);
//			Unmarshaller unmarshaller=jaxbContext.createUnmarshaller();
//			UserInfoBean userInfoBean=(UserInfoBean)unmarshaller.unmarshal(new File("userInfo.xml"));
//		
//			System.out.println("name:"+userInfoBean.getName());
//			System.out.println("aadharnumber:"+userInfoBean.getUserOtherInfoBean().getAadharnumber());
//			
//			
//		} catch (JAXBException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		//by using json unmarshalling	
		try {
			
			ObjectMapper objectMapper=new ObjectMapper();
			UserInfoBean userInfoBean=objectMapper.readValue(new File("empjsonmarshalling5.json"), UserInfoBean.class);
			System.out.println("id:"+userInfoBean.getEmpId());
			System.out.println("name:"+userInfoBean.getName());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
}