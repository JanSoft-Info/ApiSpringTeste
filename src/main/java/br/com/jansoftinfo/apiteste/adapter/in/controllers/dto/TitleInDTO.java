package br.com.jansoftinfo.apiteste.adapter.in.controllers.dto;

import br.com.jansoftinfo.apiteste.adapter.utils.validators.TitleStatusValidator;
import br.com.jansoftinfo.apiteste.adapter.utils.validators.TitleTypeValidator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TitleInDTO {
    @JsonProperty("id_titulo")
    private Long receivableId;

    @JsonProperty("id_venda_titulo")
    private Long operationId;

    @JsonProperty("id_cliente_titulo")
    private Long customerId;

    @JsonProperty("data_hora_titulo")
    @NotNull(message = "{error.receivable.datetime.null}")
    private LocalDateTime receivableDateTime;

    @JsonProperty("data_vencimento_titulo")
    @NotNull(message = "{error.receivable.duedate.null}")
    private LocalDate receivableDueDate;

    @JsonProperty("valor_titulo")
    @NotNull(message = "{error.receivable.value.null}")
    @NotBlank(message = "{error.receivable.value.blank}")
    private BigDecimal receivableValue;

    @JsonProperty("tipo_titulo")
    @NotNull(message = "{error.receivable.type.null}")
    @NotBlank(message = "{error.receivable.type.blank}")
    @TitleTypeValidator(message = "{error.receivable.type.invalid}")
    private String receivableType;

    @JsonProperty("status_titulo")
    @NotNull(message = "{error.receivable.status.null}")
    @NotBlank(message = "{error.receivable.status.blank}")
    @TitleStatusValidator(message = "{error.receivable.status.invalid}")
    private String receivableStatus;
}