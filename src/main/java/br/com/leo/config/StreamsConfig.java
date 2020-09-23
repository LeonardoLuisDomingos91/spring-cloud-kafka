package br.com.leo.config;

import br.com.leo.channel.GreetingsStreams;
import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding( GreetingsStreams.class)
public class StreamsConfig {
}
