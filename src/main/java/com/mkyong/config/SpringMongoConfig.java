package com.mkyong.config;


import org.mongeez.Mongeez;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

@Configuration
public class SpringMongoConfig extends AbstractMongoConfiguration {

	@Override
	public String getDatabaseName() {
		return "yourdb";
	}

	@Override
	@Bean
	public Mongo mongo() throws Exception {
		return new MongoClient("127.0.0.1");
	}
	
	@Bean(name = "mongeezTest")
	public Mongeez mongeez() throws Exception {
		Mongeez mongeez = new Mongeez();
		mongeez.setFile(new ClassPathResource("/config/mongeez/master.xml"));
		mongeez.setMongo(mongo());
		// mongeez.setAuth(new MongoAuth(mongoProperties.getUsername(), new
		// String(mongoProperties.getPassword())));
		mongeez.setDbName(getDatabaseName());
		mongeez.process();
		return mongeez;
	}

}