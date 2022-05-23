package com.example.async.asyncmethod;

import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncService {
	private static Logger log = LoggerFactory.getLogger(AsyncService.class);
	
	@Async
	public void asyncMethod(String value) throws InterruptedException {
		//Intentional delay
		Thread.sleep(5000);
		
		log.info("Ejecutando método de manera asíncrona" + value);
	}
	
	@Async
	public CompletableFuture<Integer> asyncMethodWithReturnType(int a, int b) throws InterruptedException {
		log.info("Inicia la ejecución del método de manera asíncrona");
		Integer result = a + b;
		
		//Intentional delay
		Thread.sleep(5000);
		
		log.info("Termina ejecución del método de manera asíncrona");
		return CompletableFuture.completedFuture(result);
	}
}
