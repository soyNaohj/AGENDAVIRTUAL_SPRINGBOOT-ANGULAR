package com.johan.contactisapi;

import com.johan.contactisapi.entity.Contact;
import com.johan.contactisapi.repository.ContactRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class ContactisapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContactisapiApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(ContactRepository contactRepository){
		return args -> {
					List<Contact> contacts = Arrays.asList(
							new Contact("Carlos", "carlos@gmail.com", LocalDateTime.now()),
							new Contact("Felipe", "felipe@gmail.com", LocalDateTime.now()),
							new Contact("Juan", "juan@gmail.com", LocalDateTime.now()),
							new Contact("Andres", "andres@gmail.com", LocalDateTime.now()),
							new Contact("Tamara", "tamara@gmail.com", LocalDateTime.now())
					);
					contactRepository.saveAll(contacts);
		};
	}
}
