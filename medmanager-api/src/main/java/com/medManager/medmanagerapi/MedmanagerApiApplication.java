/*
Author: Adwait Wadekar
File description: Start point of the web application. Annotation instructs the framework to host
	the app on the embedded server
 */
package com.medManager.medmanagerapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MedmanagerApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedmanagerApiApplication.class, args);
	}

}
