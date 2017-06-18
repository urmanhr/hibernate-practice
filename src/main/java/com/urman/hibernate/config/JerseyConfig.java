package com.urman.hibernate.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import com.urman.hibernate.resources.TestResource;

@Configuration
public class JerseyConfig extends ResourceConfig {

	public JerseyConfig() {

		register(HealthController.class);
		register(TestResource.class);

	}

}