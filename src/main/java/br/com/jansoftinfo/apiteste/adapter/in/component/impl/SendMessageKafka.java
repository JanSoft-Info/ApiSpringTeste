package br.com.jansoftinfo.apiteste.adapter.in.component.impl;

import br.com.jansoftinfo.apiteste.adapter.in.component.SendMessage;
import br.com.jansoftinfo.apiteste.adapter.in.dtos.MessageDTO;

public class SendMessageKafka implements SendMessage {
    @Override
    public void sendMessage(MessageDTO message) {
        System.out.println("KAFKA");
    }
}
