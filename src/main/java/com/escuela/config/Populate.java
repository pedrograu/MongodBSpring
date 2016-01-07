package com.escuela.config;

import org.mongeez.Mongeez;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Populate {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new AnnotationConfigApplicationContext(DatabaseConfiguration.class);
		
		Mongeez mongeez = context.getBean(Mongeez.class);
		
		mongeez.process();

	}

}
