package br.com.jansoftinfo.apiteste.domain.entities;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "produto")
public class ProductEntity {
    @Id
    @Column(name = "id_produto")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @NonNull
    @Column(name = "descricao_produto")
    private String productDescription;

    @NonNull
    @Column(name = "unidade_produto")
    private String productUnity;

    @NonNull
    @Column(name = "valor_produto")
    private BigDecimal productValue;

    /* RELACIONAMENTOS JPA */

    // N produtos para N vendas
    @ManyToMany
    private List<SaleEntity> sales;
}
