package br.com.jansoftinfo.apiteste.adapter.in.dto;

import br.com.jansoftinfo.apiteste.adapter.utils.OperationStatusEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OperationDTO {
    @JsonProperty("id_operation")
    private Long operationId;

    @JsonProperty("id_cliente")
    private Long customerId;

    @JsonProperty("valor_operacao")
    private BigDecimal operationValue;

    @JsonProperty("data_hora_operacao")
    private LocalDateTime operationDateTime;

    @JsonProperty("status_operacao")
    private OperationStatusEnum operationStatus;
}