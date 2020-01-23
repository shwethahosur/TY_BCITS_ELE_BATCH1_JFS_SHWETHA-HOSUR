package com.bcits.springcoreannotations;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;import org.springframework.jmx.support.MetricType;

import com.bcits.springannotation.beans.MessageBean;
import com.bcits.springannotation.config.MessageConfig;

public class MessageTest {
public static void main(String[] args) {
	ApplicationContext context=new AnnotationConfigApplicationContext(MessageConfig.class);
	((ConfigurableApplicationContext)context).registerShutdownHook();
	
	
	MessageBean messageBean=context.getBean(MessageBean.class);
	System.out.println(messageBean.getMessage());
}
}
