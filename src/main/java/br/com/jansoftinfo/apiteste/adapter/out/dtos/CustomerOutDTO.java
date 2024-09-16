package br.com.jansoftinfo.apiteste.adapter.out.dtos;

import java.io.Serializable;

public record CustomerOutDTO(
        Long id_cliente,
        String cpf_cnpj_cliente,
        String nome_cliente,
        String tipo_cliente
) implements Serializable {}