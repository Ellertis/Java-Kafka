package com.KafkaDemo.Producer;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

@SpringBootApplication
public class ProducerApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(ProducerApplication.class, args);
        }
	}
