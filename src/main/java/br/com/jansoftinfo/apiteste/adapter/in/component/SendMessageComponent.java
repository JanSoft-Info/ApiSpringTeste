package br.com.jansoftinfo.apiteste.adapter.in.component;

import br.com.jansoftinfo.apiteste.adapter.in.component.impl.SendMessageKafka;
import br.com.jansoftinfo.apiteste.adapter.in.component.impl.SendMessageSqs;
import br.com.jansoftinfo.apiteste.adapter.in.dtos.MessageDTO;
import org.springframework.stereotype.Component;

import java.util.Map;

import static br.com.jansoftinfo.apiteste.commons.Constants.MESSAGETYPE_KAFKA;
import static br.com.jansoftinfo.apiteste.commons.Constants.MESSAGETYPE_SQS;

@Component
public class SendMessageComponent {
    private final Map<String, SendMessage> map = Map.of(
            MESSAGETYPE_KAFKA, new SendMessageKafka(),
            MESSAGETYPE_SQS, new SendMessageSqs()
    );

    public MessageDTO postMessage(MessageDTO message) {
        map.get(message.typeMessage()).sendMessage(message);
        return message;
    }
}