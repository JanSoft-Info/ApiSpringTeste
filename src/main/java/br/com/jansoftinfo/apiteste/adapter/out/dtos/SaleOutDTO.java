package br.com.jansoftinfo.apiteste.adapter.out.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SaleOutDTO {
    @JsonProperty("id_venda")
    private Long saleId;

    @JsonProperty("valor_venda")
    private BigDecimal saleValue;

    @JsonProperty("data_hora_venda")
    private LocalDateTime saleDateTime;

    @JsonProperty("status_venda")
    private String saleStatus;

    @JsonProperty("cliente_venda")
    private CustomerOutDTO customerSale;

    @JsonProperty("produtos_venda")
    private List<ProductOutDTO> productsSale;

    @JsonProperty("titulos_venda")
    private List<TitleOutDTO> titlesSale;
}