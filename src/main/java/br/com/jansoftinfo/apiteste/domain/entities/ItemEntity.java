package br.com.jansoftinfo.apiteste.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "item")
public class ItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_item")
    private Long itemId;

    @NonNull
    @Column(name = "id_venda")
    private Long saleId;

    @NonNull
    @Column(name = "id_produto")
    private Long productId;

    @NonNull
    @Column(name = "quantidade")
    private BigDecimal itemQuantity;
}