package br.com.jansoftinfo.apiteste.adapter.out.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TitleOutDTO {
    @JsonProperty("id_titulo")
    private Long titleId;

    @JsonProperty("data_hora_titulo")
    private LocalDateTime titleDateTime;

    @JsonProperty("data_vencimento_titulo")
    private LocalDate titleDueDate;

    @JsonProperty("valor_titulo")
    private BigDecimal titleValue;

    @JsonProperty("tipo_titulo")
    private String titleType;

    @JsonProperty("status_titulo")
    private String titleStatus;
}