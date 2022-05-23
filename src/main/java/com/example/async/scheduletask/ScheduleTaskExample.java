package com.example.async.scheduletask;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduleTaskExample {

//	@Scheduled(fixedDelay = 5000)
	public void scheduleFixedDelayTask() {
	    System.out.println("Fixed delay task - " + System.currentTimeMillis() / 1000);
	}
	
//	second, minute, hour, day of month, month, day(s) of week
	@Scheduled(cron = "0 0 * * * *" )
	public void scheduleCronTask() {
	    System.out.println("Cron task - " + System.currentTimeMillis() / 1000);
	}
}
