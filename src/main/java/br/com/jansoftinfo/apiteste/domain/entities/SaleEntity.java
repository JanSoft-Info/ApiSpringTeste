package br.com.jansoftinfo.apiteste.domain.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
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
public class SaleEntity implements Serializable {
    @Id
    @Column(name = "id_venda")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long saleId;

    @Column(name = "id_cliente_venda")
    private Long saleCustomerId;

    @Column(name = "valor_venda")
    private BigDecimal saleValue;

    @Column(name = "data_hora_venda")
    private LocalDateTime saleDateTime;

    @Column(name = "status_venda")
    private String saleStatus;

    /* RELACIONAMENTOS JPA */

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente_venda", referencedColumnName = "id_cliente", insertable = false, updatable = false)
    private CustomerEntity customerEntity;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_venda_titulo", referencedColumnName = "id_venda", insertable = false, updatable = false)
    private List<TitleEntity> titleEntity;
}