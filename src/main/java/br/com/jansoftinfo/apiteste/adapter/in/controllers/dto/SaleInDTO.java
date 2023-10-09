package br.com.jansoftinfo.apiteste.adapter.in.controllers.dto;

import br.com.jansoftinfo.apiteste.adapter.utils.validators.SaleStatusValidator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SaleInDTO {
    @JsonProperty("id_operation")
    private Long operationId;

    @Email(message = "dsfkjslkfjdskljklfsjklgjs")
    private String email;

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
    @SaleStatusValidator(message = "{error.operation.status.invalid}")
    private String operationStatus;

    @JsonProperty("cliente_operacao")
    private CustomerInDTO customer;

    @JsonProperty("recebiveis_operacao")
    private List<TitleInDTO> receivables;
}