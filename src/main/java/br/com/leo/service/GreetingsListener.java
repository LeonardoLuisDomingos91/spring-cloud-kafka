package br.com.leo.service;

import br.com.leo.channel.GreetingsStreams;
import lombok.extern.slf4j.Slf4j;
import br.com.leo.model.Greetings;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class GreetingsListener {

    @StreamListener( GreetingsStreams. INPUT )
    public  void  handleGreetings ( @Payload Greetings greetings ) {
        log.info ( "Saudações recebidas: {}" , greetings );
    }
}
