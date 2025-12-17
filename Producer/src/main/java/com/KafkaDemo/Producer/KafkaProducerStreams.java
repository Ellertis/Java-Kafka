package com.KafkaDemo.Producer;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.util.MimeTypeUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.function.Supplier;

@Configuration
public class KafkaProducerStreams {
    @Bean
    public Supplier<Package> sendPackageInfo() {
        Random randomID = new Random();
        return () -> {
            Package mypackage = new Package(Math.random() * 10, Math.random() * 10, "Important package: " + randomID.nextInt());
            try {
                logPckg(mypackage,"Producer : ");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Sending :" + mypackage.getPackageName() + " | " + mypackage.getPrice() + " | " + mypackage.getWeight());
            return mypackage;
        };
    }
    @Bean
    public Supplier<Message<String>> sendPackageStatus() {
        Random randomID = new Random();
        return () -> {
            String packageName = "Important package: "  + randomID.nextInt();
            String status = randomID.nextBoolean() ? "in process" : "delivered";
            System.out.println("Sending: " + status);
            return MessageBuilder.withPayload(packageName + ":" + status)
                    .setHeader(KafkaHeaders.KEY, packageName.getBytes())
                    .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.TEXT_PLAIN)
                    .build();
        };
    }
    public void logPckg(Package pckg,String comment) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("LogFile.txt",true));
        writer.newLine();
        writer.write(comment + "Name - " + pckg.getPackageName()+
                " Weight - " + pckg.getWeight()+
                " Price - " + pckg.getPrice());
        writer.close();
    }
    //Clear log on application launch
    @PostConstruct
    public void ClearLogFile() throws IOException {
        File file = new File("LogFile.txt");
        if(file.exists()){
            file.delete();
        }
        FileWriter newFile = new FileWriter(file,true);
        newFile.close();
    }
}