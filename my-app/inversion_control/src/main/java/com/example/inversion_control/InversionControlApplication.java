package com.example.inversion_control;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class InversionControlApplication {
		public static void main(String[] args) {


			AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MobilesConfig.class);

			Mobiles obj = context.getBean("getOnePlusObject",Mobiles.class);
			obj.getModelAndColour();
		}

	}


