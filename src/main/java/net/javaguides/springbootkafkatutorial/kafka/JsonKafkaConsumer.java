package net.javaguides.springbootkafkatutorial.kafka;

import net.javaguides.springbootkafkatutorial.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class JsonKafkaConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaProducer.class);

    @KafkaListener(topics = "javaguides_json", groupId = "myGroup")
     public void consume(User user) {
        LOGGER.info(String.format("Json message received -> %s", user.toString()));

     }
}
