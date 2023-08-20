package com.lazybeast.sampleKafka.controller;

import com.lazybeast.sampleKafka.dto.MessageDto;
import com.lazybeast.sampleKafka.dto.SomePoJo;
import com.lazybeast.sampleKafka.service.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {

    @Autowired
    private KafkaService kafkaService;

    @GetMapping("/publish/{message}")
    public ResponseEntity<?> publish(@PathVariable(name = "message") String message){
        try {
            for (long i=0; i<12; i++){
                kafkaService.sendMessage(new MessageDto(i, message));
            }
            return ResponseEntity.ok("Message Sent 👍");
        } catch (Exception ex){
            ex.printStackTrace();
            return ResponseEntity.internalServerError().body(ex.getMessage());
        }
    }
}
