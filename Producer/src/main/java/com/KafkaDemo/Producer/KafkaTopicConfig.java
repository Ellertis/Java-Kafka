package com.KafkaDemo.Producer;

import jakarta.annotation.PostConstruct;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaTopicConfig {
    @Bean
    public NewTopic createTopic(){
        return new NewTopic("config-topic",2,(short)1);
    }
    @Bean
    public NewTopic createTopic2(){
        return new NewTopic("config-topic2",2,(short)1);
    }
    public NewTopic MycreateTopic(String Name,Integer numPartitions){
        return new NewTopic(Name,numPartitions,(short)1);
    }
    //@PostConstruct
    public void InitNewTopic(){
        MycreateTopic("config-topic",2);
        MycreateTopic("config-topic2", 2);

    }
}
