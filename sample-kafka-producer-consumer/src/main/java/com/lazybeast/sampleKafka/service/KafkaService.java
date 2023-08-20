package com.lazybeast.sampleKafka.service;

import com.lazybeast.sampleKafka.dto.MessageDto;
import com.lazybeast.sampleKafka.dto.SomePoJo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class KafkaService {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    private String topicName = "sampleKafka-demo-topic";

    public void sendMessage(MessageDto messageDto){
        CompletableFuture<SendResult<String, Object>> completableFuture = kafkaTemplate.send(topicName, messageDto);
        completableFuture.whenComplete((result, ex)->{
            if (ex == null) {
                System.out.println("Message Sent to topic: " + result.getRecordMetadata().topic() + ", value: " + messageDto.toString() + ", offset: " + result.getRecordMetadata().offset() + ", partition: " + result.getRecordMetadata().partition());
            } else {
                System.out.println("Error while sending message: " + messageDto.toString() + ", Error: " + ex.getMessage());
            }
        });
    }
}
