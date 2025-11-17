package br.com.jansoftinfo.apiteste.adapter.in.component;

import br.com.jansoftinfo.apiteste.adapter.in.dtos.MessageDTO;

public interface SendMessage {
    void sendMessage(MessageDTO message);
}