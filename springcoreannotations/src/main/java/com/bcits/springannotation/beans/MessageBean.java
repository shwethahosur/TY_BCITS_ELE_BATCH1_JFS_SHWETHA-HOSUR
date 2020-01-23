package com.bcits.springannotation.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import lombok.Data;

@Data
public class MessageBean implements InitializingBean,DisposableBean{
private String message;
public MessageBean() {
	System.out.println("its instantiation phase");
}

@Override
public void destroy() throws Exception {
	System.out.println("destroy phase");
	
}

@Override
public void afterPropertiesSet() throws Exception {
	System.out.println("initialization phase");
	
}

}
