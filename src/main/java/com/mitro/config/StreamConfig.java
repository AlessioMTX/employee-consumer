package com.mitro.config;

import com.mitro.stream.GreetingsStream;
import org.springframework.cloud.stream.annotation.EnableBinding;

/**
 * Created by AlessioMitrotta on 26-Jun-18.
 * If you have any problem with this code please let me know at amitrotta@soldo.com
 */
@EnableBinding(GreetingsStream.class)
public class StreamConfig {
}
