package com.mitro.service;

import com.mitro.model.Greetings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;


/**
 * Created by AlessioMitrotta on 25-Jun-18.
 * If you have any problem with this code please let me know at amitrotta@soldo.com
 */
@Component
public class GreetingsListener {

    Logger logger = LoggerFactory.getLogger(GreetingsListener.class);

    @StreamListener("greetings-out")
    public void handleGreetingsInput(@Payload Greetings greetings) throws Exception {
        logger.info("Greetings input -> {}", greetings);
        if (greetings.getMessage().equals("hello")) {
            throw new Exception("eer");
        }
    }

    @StreamListener("dead-out")
    public void dlq(Message<?> in) {
        System.out.println("DLQ:" + in);
    }

}
