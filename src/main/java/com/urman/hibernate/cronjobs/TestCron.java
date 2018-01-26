package com.urman.hibernate.cronjobs;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TestCron {

	@Scheduled(cron = "0 23 17 * * ?")
	public void cronJob1() {
		System.out.println("test cron");
		System.out.println(new Date());
	}

}
