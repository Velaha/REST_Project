package fr.uge.rest.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

@SpringBootApplication
public class MainApplication {
	public static void main(String[] args) {
		/*
		if (args.length == 0) {
			System.out.println(("Please give one argument"));
			return;
		}
		var port = args[0];
		SpringApplication app = new SpringApplication(MainApplication.class);
		app.setDefaultProperties(Collections.singletonMap("server.port", port));
		app.run(args);

		 */
		SpringApplication.run(MainApplication.class, args);
	}
}
