package net.javaguides.springbootkafkatutorial.controller;

import net.javaguides.springbootkafkatutorial.kafka.JsonKafkaProducer;
import net.javaguides.springbootkafkatutorial.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2/kafka")
public class JsonMessageController {

    private JsonKafkaProducer jsonKafkaProducer;


    public JsonMessageController(JsonKafkaProducer jsonKafkaProducer) {
        this.jsonKafkaProducer = jsonKafkaProducer;
    }

    @PostMapping("/publish")
     public ResponseEntity<String> publish(@RequestBody User user) {
        jsonKafkaProducer.sendJsonMessage(user);
        return ResponseEntity.ok("Json message sent to kafka topic");
     }
}
