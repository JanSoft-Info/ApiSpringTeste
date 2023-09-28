package br.com.jansoftinfo.apiteste.adapter.in.dto;

import br.com.jansoftinfo.apiteste.adapter.utils.validators.ReceivableStatusValidator;
import br.com.jansoftinfo.apiteste.adapter.utils.validators.ReceivableTypeValidator;
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
public class ReceivableDTO {
    @JsonProperty("id_recebivel")
    private Long receivableId;

    /*@JsonProperty("id_operacao")
    private Long operationId;

    @JsonProperty("id_cliente")
    private Long customerId;*/

    @JsonProperty("data_hora_recebivel")
    @NotNull(message = "{error.receivable.datetime.null}")
    private LocalDateTime receivableDateTime;

    @JsonProperty("data_vencimento_recebivel")
    @NotNull(message = "{error.receivable.duedate.null}")
    private LocalDate receivableDueDate;

    @JsonProperty("valor_operacao")
    @NotNull(message = "{error.receivable.value.null}")
    @NotBlank(message = "{error.receivable.value.blank}")
    private BigDecimal receivableValue;

    @JsonProperty("tipo_recebivel")
    @NotNull(message = "{error.receivable.type.null}")
    @NotBlank(message = "{error.receivable.type.blank}")
    @ReceivableTypeValidator(message = "{error.receivable.type.invalid}")
    private String receivableType;

    @JsonProperty("status_recebivel")
    @NotNull(message = "{error.receivable.status.null}")
    @NotBlank(message = "{error.receivable.status.blank}")
    @ReceivableStatusValidator(message = "{error.receivable.status.invalid}")
    private String receivableStatus;
}