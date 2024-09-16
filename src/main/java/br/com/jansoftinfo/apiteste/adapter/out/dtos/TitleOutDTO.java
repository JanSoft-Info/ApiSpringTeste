package br.com.jansoftinfo.apiteste.adapter.out.dtos;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record TitleOutDTO(
        Long id_titulo,
        LocalDateTime data_hora_titulo,
        LocalDate data_vencimento_titulo,
        BigDecimal valor_titulo,
        String tipo_titulo,
        String status_titulo
) {}