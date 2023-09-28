package br.com.jansoftinfo.apiteste.adapter.in.dto;

import br.com.jansoftinfo.apiteste.adapter.utils.validators.OperationStatusValidator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OperationDTO {
    @JsonProperty("id_operation")
    private Long operationId;

    @JsonProperty("valor_operacao")
    @NotNull(message = "{error.operation.value.null}")
    @Digits(integer = 12, fraction = 2, message = "{error.operation.value.invalid}")
    @DecimalMin(value = "0.00", inclusive = false, message = "{error.operation.value.invalid}")
    private BigDecimal operationValue;

    @JsonProperty("data_hora_operacao")
    @NotNull(message = "{error.operation.datetime.null}")
    private LocalDateTime operationDateTime;

    @JsonProperty("status_operacao")
    @NotNull(message = "{error.operation.status.null}")
    @NotBlank(message = "{error.operation.status.blank}")
    @OperationStatusValidator(message = "{error.operation.status.invalid}")
    private String operationStatus;

    @JsonProperty("cliente_operacao")
    private CustomerDTO customer;

    @JsonProperty("recebiveis_operacao")
    private List<ReceivableDTO> receivables;
}