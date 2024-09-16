package br.com.jansoftinfo.apiteste.adapter.out.dtos;

import java.math.BigDecimal;

public record ProductOutDTO(
        Long id_produto,
        String descricao_produto,
        String unidade_produto,
        BigDecimal valor_produto
) {}