package com.bcits.hugecase1.consumer.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name="consumer_signup_info")
public class ConsumerSignUp implements Serializable{
	@Id
	@Column
	private  int Meternumber;
	@Column
	private  String consumerFirstname;
	
	@Column
	private  String consumerLastname;
	@Column
	private long consumerphno;
	
	@Column
	private String consumer_mail_id;
	
	@Column
	private String password;
	@Column
	private  String Region;
	@Column
	private  String Type_of_consumer;
//	public int getMeternumber() {
//		return Meternumber;
//	}
//	public void setMeternumber(int meternumber) {
//		Meternumber = meternumber;
//	}
//	public String getConsumerFirstname() {
//		return consumerFirstname;
//	}
//	public void setConsumerFirstname(String consumerFirstname) {
//		this.consumerFirstname = consumerFirstname;
//	}
//	public String getConsumerLastname() {
//		return consumerLastname;
//	}
//	public void setConsumerLastname(String consumerLastname) {
//		this.consumerLastname = consumerLastname;
//	}
//	public long getConsumerphno() {
//		return consumerphno;
//	}
//	public void setConsumerphno(long consumerphno) {
//		this.consumerphno = consumerphno;
//	}
//	public String getConsumer_mail_id() {
//		return consumer_mail_id;
//	}
//	public void setConsumer_mail_id(String consumer_mail_id) {
//		this.consumer_mail_id = consumer_mail_id;
//	}
//	public String getPassword() {
//		return password;
//	}
//	public void setPassword(String password) {
//		this.password = password;
//	}
//	public String getRegion() {
//		return Region;
//	}
//	public void setRegion(String region) {
//		Region = region;
//	}
//	public String getType_of_consumer() {
//		return Type_of_consumer;
//	}
//	public void setType_of_consumer(String type_of_consumer) {
//		Type_of_consumer = type_of_consumer;
//	}
//	 
}
