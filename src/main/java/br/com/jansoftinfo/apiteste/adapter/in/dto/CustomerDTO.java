package br.com.jansoftinfo.apiteste.adapter.in.dto;

import br.com.jansoftinfo.apiteste.adapter.utils.CustomerTypeEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {
    @JsonProperty("id_cliente")
    private Long customerId;

    @NotNull(message = "informe o cpf/cnpj do cliente")
    @JsonProperty("cpf_cnpj")
    private String documentId;

    @NotNull(message = "informe o nome do cliente")
    @JsonProperty("nome_cliente")
    private String customerName;

    @JsonProperty("tipo_cliente")
    private CustomerTypeEnum customerType;
}