package br.com.jansoftinfo.apiteste.adapter.out.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductOutDTO {
    @JsonProperty("id_produto")
    private Long productId;

    @JsonProperty("descricao_produto")
    private String productDescription;

    @JsonProperty("unidade_produto")
    private String productUnity;

    @JsonProperty("valor_produto")
    private BigDecimal productValue;
}