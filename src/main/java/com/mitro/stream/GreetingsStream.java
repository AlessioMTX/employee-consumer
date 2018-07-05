package com.mitro.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * Created by AlessioMitrotta on 25-Jun-18.
 * If you have any problem with this code please let me know at amitrotta@soldo.com
 */
public interface GreetingsStream {
    String OUTPUT = "greetings-out";

    @Input(OUTPUT)
    SubscribableChannel inboundGreetings();
}
