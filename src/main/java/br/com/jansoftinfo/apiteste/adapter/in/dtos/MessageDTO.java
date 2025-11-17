package br.com.jansoftinfo.apiteste.adapter.in.dtos;

public record MessageDTO(
        String typeMessage,
        String topic,
        String message
) {}