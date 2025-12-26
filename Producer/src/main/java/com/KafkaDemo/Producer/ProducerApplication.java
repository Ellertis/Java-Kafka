package com.KafkaDemo.Producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class ProducerApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(ProducerApplication.class, args);
        }
	}
