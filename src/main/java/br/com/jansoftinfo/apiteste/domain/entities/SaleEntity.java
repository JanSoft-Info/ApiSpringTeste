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
    @ManyToOne
    @JoinColumn(name = "id_cliente_venda")
    private CustomerEntity customer;

    @OneToMany(mappedBy = "sale")
    private List<TitleEntity> titles;
}