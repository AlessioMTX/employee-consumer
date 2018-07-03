package com.mitro.service;

import com.mitro.model.Greetings;
import com.mitro.stream.GreetingsStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;


/**
 * Created by AlessioMitrotta on 25-Jun-18.
 * If you have any problem with this code please let me know at amitrotta@soldo.com
 */
@Component
public class GreetingsListener {

    Logger logger = LoggerFactory.getLogger(GreetingsListener.class);

    @StreamListener(GreetingsStream.INPUT)
    public void handleGreetingsInput(@Payload Greetings greetings) {
        logger.info("Greetings input -> {}", greetings);
    }

    @StreamListener(GreetingsStream.OUTPUT)
    public void handleGreetingsOutput(@Payload Greetings greetings) {
        logger.info("Greetings output -> {}", greetings);
    }
}
