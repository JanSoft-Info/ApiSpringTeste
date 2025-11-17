package br.com.jansoftinfo.apiteste.adapter.in.component.impl;

import br.com.jansoftinfo.apiteste.adapter.in.component.SendMessage;
import br.com.jansoftinfo.apiteste.adapter.in.dtos.MessageDTO;
import org.springframework.stereotype.Component;

@Component
public class SendMessageSqs implements SendMessage {
    @Override
    public void sendMessage(MessageDTO message) {
        System.out.println("SQS");
    }
}
