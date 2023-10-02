package br.com.jansoftinfo.apiteste.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "titulo")
public class TitleEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_titulo")
    private Long titleId;

    @Column(name = "id_venda_titulo")
    private Long titleSaleId;

    @Column(name = "id_cliente_titulo")
    private Long titleCustomerId;

    @Column(name = "data_hora_titulo")
    private LocalDateTime titleDateTime;

    @Column(name = "data_vencimento_titulo")
    private LocalDate titleDueDate;

    @Column(name = "valor_titulo")
    private BigDecimal titleValue;

    @Column(name = "tipo_titulo")
    private String titleType;

    @Column(name = "status_titulo")
    private String titleStatus;

    /* RELACIONAMENTOS JPA */

    @ManyToOne
    private SaleEntity titleSale;
}