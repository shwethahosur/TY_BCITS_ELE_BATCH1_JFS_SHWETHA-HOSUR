package com.bcits.springannotation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bcits.springannotation.PostProcessor.MyBeanFactoryPostProcessor;
import com.bcits.springannotation.PostProcessor.MyBeanPostProcessor;
import com.bcits.springannotation.beans.MessageBean;

@Configuration
public class MessageConfig {
@Bean(name="messageBean")
	public MessageBean getMessageBean() {
		MessageBean messageBean=new MessageBean();
		messageBean.setMessage("welcome to spring .........");
		
		
		return messageBean;
		
	}// end of getmessagebean()
@Bean
	public MyBeanPostProcessor getMyBPP() {
		return new MyBeanPostProcessor();
	}
	@Bean
	public MyBeanFactoryPostProcessor getMYBFPP() {
		return new MyBeanFactoryPostProcessor();
	}
}
