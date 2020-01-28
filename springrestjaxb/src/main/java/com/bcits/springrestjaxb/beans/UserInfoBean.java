package com.bcits.springrestjaxb.beans;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;

import lombok.Data;
@Data
@XmlRootElement(name="User_info")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonRootName("userInfo")
public class UserInfoBean {
	
//	@XmlElement(name="user_id")
	//@XmlAttribute
	@JsonProperty("employeeId")
	private Integer empId;
//	@XmlElement
	@XmlAttribute//to make element as attribute
	private String name;
	@XmlElement
//	@XmlTransient //to avoid binding
	private Long mobileno;
	@XmlElement
	private String officialMail;
	@XmlElement
	private Date dateOfBirth;
	@XmlElement
	private Date dateOfJoining;
	@XmlElement
	private String designation;
	@XmlElement
	private String bloodGroup;
	@XmlElement
	private double salary;
	@XmlElement(name="department_id")
	private Integer deptId;
	@XmlElement
	private Integer managerId;
	@XmlElement
	@JsonIgnore
	private String password;
	
	@XmlElement(name="user-other-info")
	private UserOtherInfoBean userOtherInfoBean;
	
	
	@XmlElementWrapper(name="user-addresses-list")
	private List<UserAddressBean>useraddresseslist;
	
	
}