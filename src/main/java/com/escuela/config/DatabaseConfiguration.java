package com.escuela.config;


import org.mongeez.Mongeez;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

@Configuration
@EnableMongoRepositories("com.escuela.repository")
//@EnableMongoAuditing(auditorAwareRef = "springSecurityAuditorAware")
public class DatabaseConfiguration extends AbstractMongoConfiguration  {

    private final Logger log = LoggerFactory.getLogger(DatabaseConfiguration.class);



    @Override
    protected String getDatabaseName() {
        return "escuela";
    }

    @Override
    public Mongo mongo() throws Exception {
    	return new MongoClient();
    }

    @Bean
    public Mongeez mongeez() throws Exception {
        log.debug("Configuring Mongeez");
        mongo().dropDatabase(getDatabaseName());
        Mongeez mongeez = new Mongeez();
        
        mongeez.setFile(new ClassPathResource("/config/mongeez/master.xml"));
        mongeez.setMongo(mongo());
//        mongeez.setAuth(new MongoAuth(mongoProperties.getUsername(), new String(mongoProperties.getPassword())));
        mongeez.setDbName(getDatabaseName());
//        mongeez.process();
        return mongeez;
    }
}
