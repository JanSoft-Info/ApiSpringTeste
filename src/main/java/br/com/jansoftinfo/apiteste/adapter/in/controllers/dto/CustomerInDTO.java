package br.com.jansoftinfo.apiteste.adapter.in.dto;

import br.com.jansoftinfo.apiteste.adapter.utils.validators.CustomerTypeValidator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerInDTO {
    @JsonProperty("id_cliente")
    private Long customerId;

    @JsonProperty("cpf_cnpj_cliente")
    @NotNull(message = "{error.customer.cpfcnpj.null}")
    @NotBlank(message = "{error.customer.cpfcnpj.blank}")
    private String documentId;

    @JsonProperty("nome_cliente")
    @NotNull(message = "{error.customer.name.null}")
    @NotBlank(message = "{error.customer.name.blank}")
    private String customerName;

    @JsonProperty("tipo_cliente")
    @NotNull(message = "{error.customer.type.null}")
    @NotBlank(message = "{error.customer.type.blank}")
    @CustomerTypeValidator(message = "{error.customer.type.invalid}")
    private String customerType;
}