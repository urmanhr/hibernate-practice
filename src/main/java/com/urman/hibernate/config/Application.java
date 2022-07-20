package com.urman.hibernate.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.trace.http.HttpTraceRepository;
import org.springframework.boot.actuate.trace.http.InMemoryHttpTraceRepository;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.urman.hibernate.resources.AccountResource;

@EnableAutoConfiguration
@SpringBootApplication
@EnableScheduling
@ComponentScan({ "com.urman.hibernate.*" })
@EntityScan(basePackages = "com.urman.hibernate.pojo")
public class Application {

	public static void main(String[] args) throws Exception {
		ApplicationContext context = SpringApplication.run(Application.class, args);
		AccountResource ar = context.getBean(AccountResource.class);
//		Runnable r1 = new Runnable() {
//			@Override
//			public void run() {
//				UID uid1 = new UID(1,1,"");
//				ar.test1(uid1);
//				try {
//					Thread.sleep(2000);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		};
//		Runnable r2 = new Runnable() {
//			@Override
//			public void run() {
//				UID uid2 = new UID(2,2,"");
//				ar.test1(uid2);
//				try {
//					Thread.sleep(3000);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		};
//		Runnable r3 = new Runnable() {
//			@Override
//			public void run() {
//				UID uid3 = new UID(3,3,"");
//				ar.test1(uid3);
//				try {
//					Thread.sleep(4000);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		};
//		while (true) {
//			Thread.sleep(1000);
//			Thread t1 = new Thread(r1);
//			t1.start();
//			Thread t2 = new Thread(r2);
//			t2.start();
//			Thread t3 = new Thread(r3);
//			t3.start();
//			Thread.sleep(1000);
//		}
	}

	@Bean
	public HttpTraceRepository httpTraceRepository() {
		return new InMemoryHttpTraceRepository();
	}

}