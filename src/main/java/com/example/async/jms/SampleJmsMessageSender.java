package com.example.async.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.example.async.jms.message.Message;
import com.example.async.jms.util.Constants;

@Component
public class SampleJmsMessageSender {

	private static Logger log = LoggerFactory.getLogger(SampleJmsMessageSender.class);
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	public void sendAdminMsg(Message message){
		log.info("Sending message...");
		jmsTemplate.convertAndSend(Constants.ADMIN_QUEUE, message);
	}
	
	public void sendCustomerMsg(Message message) {
		log.info("Sending message...");
		jmsTemplate.convertAndSend(Constants.CUSTOMER_QUEUE, message);
	}
	
}
