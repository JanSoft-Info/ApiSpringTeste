package br.com.jansoftinfo.apiteste.adapter.out.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SaleOutResumeDTO {
    @JsonProperty("id_venda")
    private Long saleId;

    @JsonProperty("valor_venda")
    private BigDecimal saleValue;

    @JsonProperty("data_hora_venda")
    private LocalDateTime saleDateTime;

    @JsonProperty("status_venda")
    private String saleStatus;

    @JsonProperty("cliente_venda")
    private String customerSale;

    @JsonProperty("produtos_venda")
    private List<ProductOutDTO> productsSale;
}