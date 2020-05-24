/*
Author: Adwait Wadekar

Code Description: This is the start point. Main method uses the SpringApplication.run() from the
		framework to start and run the app.

 */

//TODO: Look at the pom.xml files to add and update dependencies. So far it only has Spring Web.
//TODO: We might need the Spring Data JPA, and a db connection dependencies.
// TODO: I don't see any work needed here so far.

package com.dummyco.medmanagerapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MedmanagerApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedmanagerApiApplication.class, args);
	}

}
