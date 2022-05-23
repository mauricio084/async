package com.example.async.rest;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.async.asyncmethod.AsyncService;
import com.example.async.jms.SampleJmsMessageSender;
import com.example.async.jms.message.Message;

@RestController
public class AsyncController {

	private static Logger log = LoggerFactory.getLogger(AsyncController.class);
	
	@Autowired
	private AsyncService asyncService;
	
	@Autowired
	private SampleJmsMessageSender jmsMessageSender;
	
	@GetMapping("sinRetorno")
	public void add() throws InterruptedException {
		System.out.println("hilo principal");
		
		asyncService.asyncMethod("Hola mundo probando un metodo asincrono sin retorno");
		
		System.out.println("Continua el hio principal");
		
	}
	
	@GetMapping("add")
	public Integer add(@RequestParam int a, @RequestParam int b) {
		int result = 0;
		try {
			CompletableFuture<Integer> completableFuture = asyncService.asyncMethodWithReturnType(a, b);
			
			result = completableFuture.get();
		
		} catch (InterruptedException | ExecutionException e) {
			log.error(e.getMessage(), e);
		}
		
		return result;
	}
	
	@PutMapping("sendAdminMessage")
	public String sendAdminMessage(@RequestParam String message) {
		jmsMessageSender.sendAdminMsg(new Message(message));	
		return "Mensaje enviado a la cola";
	}
	
	@PutMapping("sendCustomerMessage")
	public String sendCustomerMessage(@RequestParam String message) {
		jmsMessageSender.sendCustomerMsg(new Message(message));
		return "Mensaje enviado a la cola";
	}
}
