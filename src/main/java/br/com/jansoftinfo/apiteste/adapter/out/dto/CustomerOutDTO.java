package br.com.jansoftinfo.apiteste.adapter.out.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerOutDTO {
    @JsonProperty("id_cliente")
    private Long customerId;

    @JsonProperty("cpf_cnpj_cliente")
    private String documentId;

    @JsonProperty("nome_cliente")
    private String customerName;

    @JsonProperty("tipo_cliente")
    private String customerType;
}