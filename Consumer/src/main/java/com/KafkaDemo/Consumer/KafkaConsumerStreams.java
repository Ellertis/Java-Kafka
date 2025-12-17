package com.KafkaDemo.Consumer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.function.Consumer;

@Configuration
public class KafkaConsumerStreams {
    @Bean
    public Consumer<Package> processPackage(){
        return mypackage ->{
            try {
                logPckg(mypackage,"Consumer : ");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Received :" + mypackage.getPackageName() + " | " + mypackage.getPrice() + " | " + mypackage.getWeight());
        };
    }
    @Bean
    public Consumer<String> processPackageStatus(){
        return status ->{
            System.out.println("Received :" + status);
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
}
