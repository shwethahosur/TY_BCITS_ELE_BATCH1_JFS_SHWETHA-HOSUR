package com.bcits.springrestjaxb.apptest;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.codehaus.jackson.map.ObjectMapper;

import com.bcits.springrestjaxb.beans.EmployeeInfoBean;
import com.bcits.springrestjaxb.beans.UserAddressBean;
import com.bcits.springrestjaxb.beans.UserInfoBean;
import com.bcits.springrestjaxb.beans.UserInfoBean;
import com.bcits.springrestjaxb.beans.UserOtherInfoBean;

public class UserMarshaling {
	public static void main(String[] args) {
		UserInfoBean userInfo=new UserInfoBean();
		userInfo.setEmpId(999);
		userInfo.setName("shwetha");
		userInfo.setMobileno(9799999999L);
		userInfo.setDateOfBirth(new Date());
		userInfo.setDateOfJoining(new Date());
		userInfo.setDesignation("ssd");
		userInfo.setSalary(50000);
		userInfo.setDeptId(225);
		userInfo.setPassword("shwetha");
		
		UserOtherInfoBean userOtherInfoBean=new UserOtherInfoBean();
		userOtherInfoBean.setGender("female");
		userOtherInfoBean.setAadharnumber(67646776L);
	userInfo.setUserOtherInfoBean(userOtherInfoBean);
		
		UserAddressBean TempAddressInfo=new UserAddressBean();
		TempAddressInfo.setHouseNum(1);
		TempAddressInfo.setCity("hubli");
		
		UserAddressBean ParmanentAddressInfo=new UserAddressBean();
		ParmanentAddressInfo.setAddressType('p');
		ParmanentAddressInfo.setCity("hyd");
		
		List<UserAddressBean>userAddressList=new ArrayList<>();
		userAddressList.add(TempAddressInfo);
		userAddressList.add(ParmanentAddressInfo);
		userInfo.setUseraddresseslist(userAddressList);
		
		JAXBContext context;
		try {
		context = JAXBContext.newInstance(UserInfoBean.class);
			Marshaller marshaller=context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(userInfo, System.out);
			marshaller.marshal(userInfo, new File("userInfo2.xml"));
		} catch (JAXBException e) {
			System.err.println("unable to marshall.....");
			e.printStackTrace();
		}
	
//by using json marshalling
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.writerWithDefaultPrettyPrinter();// formatting
			mapper.writeValue(new File("empjsonmarshalling5.json"), userInfo);
			mapper.writeValue(System.out, userInfo);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

}
}