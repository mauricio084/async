package com.example.async.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.example.async.jms.message.Message;
import com.example.async.jms.util.Constants;

@Component
public class Receiver {

	private static Logger log = LoggerFactory.getLogger(Receiver.class);

	@JmsListener(destination = Constants.ADMIN_QUEUE)
	public void receiveAdminMessage(Message message) throws InterruptedException {
		//Intentional delay
		Thread.sleep(5000);
		
		log.info("Received Admin <" + message + ">");
	}
	
	@JmsListener(destination = Constants.CUSTOMER_QUEUE)
	public void receiveCustomerMessage(Message message) throws InterruptedException {
		//Intentional delay
		Thread.sleep(5000);
				
		log.info("Received Customer <" + message + ">");
	}

}
