package com.urman.hibernate.cronjobs;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TestCron {

	/**
	 * this job is scheduled to run daily at 5 : 23 PM
	 */
	@Scheduled(cron = "* * * * * ?")
	public void cronJob1() {
		System.out.println("test cron");
		System.out.println(new Date());
	}

}
