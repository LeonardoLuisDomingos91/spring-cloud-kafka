package br.com.leo.service;

import br.com.leo.Greetings;
import br.com.leo.channel.GreetingsStreams;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;
import org.springframework.messaging.support.MessageBuilder;


@Service
@Slf4j
public class GreetingsService {

    private final GreetingsStreams greetingsStreams;

    public GreetingsService(GreetingsStreams greetingsStreams) {
        this.greetingsStreams = greetingsStreams;
    }

    public void sendGreeting(String message, long time) {
        log.info("enviado {}", message);

        Greetings greetings = new Greetings();
        greetings.setMessage(message);
        greetings.setTimestamp(time);

        MessageChannel messageChannel = greetingsStreams.outboundGreetings();
        messageChannel.send(MessageBuilder
                .withPayload(greetings)
                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                .build());
    }
}
