package com.bcits.springcore.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import lombok.Data;

@Data
public class MessageBean implements InitializingBean,DisposableBean{ // 2nd way of initializing and destroying
private String message;
public MessageBean() {
	System.out.println("it's instantiation ophase");
}

public String getMessage() {
	return message;
}


public void setMessage(String message) {
	this.message = message;
}



@Override
public void afterPropertiesSet() throws Exception {
	System.out.println("init phase");
	
}


@Override
public void destroy() throws Exception {
	System.out.println("destroy ......");
}
// 1st way of initializing
	/*
	 * public void init() { System.out.println("its initialization phase "); }
	 * public void destroy() { System.out.println("its destruction phase "); }
	 */

}
