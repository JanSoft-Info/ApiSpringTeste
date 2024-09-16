package br.com.jansoftinfo.apiteste.adapter.out.dtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record SaleOutDTO(
        Long id_venda,
        BigDecimal valor_venda,
        LocalDateTime data_hora_venda,
        String status_venda,
        CustomerOutDTO cliente_venda,
        List<ProductOutDTO> produtos_venda,
        List<TitleOutDTO> titlesSale
) {}