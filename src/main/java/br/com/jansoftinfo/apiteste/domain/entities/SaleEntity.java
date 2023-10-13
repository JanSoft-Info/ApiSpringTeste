package br.com.jansoftinfo.apiteste.domain.entities;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "venda")
public class SaleEntity {
    @Id
    @Column(name = "id_venda")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long saleId;

    @NonNull
    @Column(name = "valor_venda")
    private BigDecimal saleValue;

    @NonNull
    @Column(name = "data_hora_venda")
    private LocalDateTime saleDateTime;

    @NonNull
    @Column(name = "status_venda")
    private String saleStatus;

    /* RELACIONAMENTOS JPA */

    // 1 vanda para 1 cliente
    @OneToOne
    @JoinColumn(name = "id_cliente")
    private CustomerEntity customer;

    // 1 venda para N títulos
    @OneToMany
    private List<TitleEntity> titles;

    // N vendas para N produtos
    @ManyToMany
    @JoinTable(name = "item",
            joinColumns = @JoinColumn(name = "id_venda"),
            inverseJoinColumns = @JoinColumn(name = "id_produto"))
    private List<ProductEntity> products;
}