package com.lazybeast.sampleKafka.controller;

import com.lazybeast.sampleKafka.dto.MessageDto;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class BasicConsumer {
//    denotes a set of consumers in a common consumer group.
//    multiple consumer instances are used to map topic partions to them, in order to increase efficiency of the task.
//    auto assignment to partition is seen with multiple consumer instances.

    @KafkaListener(topics = "sampleKafka-demo-topic", groupId = "sampleKafka-demo-consumer-group")
    public void consumer(MessageDto messageDto){
        System.out.println("Message received: " + messageDto.toString());
    }

//    @KafkaListener(topics = "sampleKafka-demo-topic", groupId = "sampleKafka-demo-consumer-group")
//    public void consumer1(String message){
//        System.out.println("Consumer1 Received: " + message);
//    }
//
//    @KafkaListener(topics = "sampleKafka-demo-topic", groupId = "sampleKafka-demo-consumer-group")
//    public void consumer2(String message){
//        System.out.println("Consumer2 Received: " + message);
//    }
//
//    @KafkaListener(topics = "sampleKafka-demo-topic", groupId = "sampleKafka-demo-consumer-group")
//    public void consumer3(String message){
//        System.out.println("Consumer3 Received: " + message);
//    }
//
//    @KafkaListener(topics = "sampleKafka-demo-topic", groupId = "sampleKafka-demo-consumer-group")
//    public void consumer4(String message){
//        System.out.println("Consumer4 Received: " + message);
//    }
}
