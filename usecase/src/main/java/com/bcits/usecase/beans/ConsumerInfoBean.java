package com.bcits.usecase.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "consumer_info")
public class ConsumerInfoBean {
	@Id
	@Column
	private int meterNo;
	@Column
	private String firstName;

	@Column
	private String lastName;
	@Column
	private Long mobileNo;

	@Column
	private String email;

	@Column
	private String userPassword;
	@Column
	private String region;
	@Column
	private String consumertype;
	@Column
	private String address;
	@Column
	private int pincode;
	@Column
	private String rrNo;

}
