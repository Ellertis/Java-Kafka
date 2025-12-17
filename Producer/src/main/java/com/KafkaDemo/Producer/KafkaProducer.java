package com.KafkaDemo.Producer;

import jakarta.annotation.PostConstruct;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

@RestController
@RequestMapping("/api")
public class KafkaProducer{

    private final KafkaTemplate<String,Package> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String,Package> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping("/send")
    public String sendMessage(@RequestParam String message){
        Package mypackage = new Package(Math.random()*10,Math.random()*10,"Important package");
        kafkaTemplate.send("config-topic", mypackage);
        return "Message sent: " + "Sent object" + " | Package price : " + mypackage.getPrice() + " Package weight : " + mypackage.getWeight();
    }
}
