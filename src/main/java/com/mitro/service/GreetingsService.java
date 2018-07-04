package com.mitro.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;
import com.mitro.model.Greetings;
import com.mitro.stream.GreetingsStream;

/**
 * Created by AlessioMitrotta on 26-Jun-18.
 * If you have any problem with this code please let me know at amitrotta@soldo.com
 */
@Service
public class GreetingsService {

    Logger logger = LoggerFactory.getLogger(GreetingsService.class);

    @Autowired
    GreetingsStream greetingsStream;

    public void receiveGreetings(final Greetings greetings) {
        MessageChannel messageChannel = greetingsStream.outboundGreetings();
        messageChannel.send(MessageBuilder
                .withPayload(greetings)
                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                .build());
    }

    public void sendGreeting(final Greetings greetings) {
        SubscribableChannel subscribableChannel = greetingsStream.inboundGreetings();
        subscribableChannel.subscribe(message -> logger.info("receiveGreetings {}", message));
    }
}
