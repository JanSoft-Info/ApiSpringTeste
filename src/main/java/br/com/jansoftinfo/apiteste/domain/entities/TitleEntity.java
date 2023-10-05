package br.com.jansoftinfo.apiteste.domain.entities;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "titulo")
public class TitleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_titulo")
    private Long titleId;

    @NonNull
    @Column(name = "data_hora_titulo")
    private LocalDateTime titleDateTime;

    @NonNull
    @Column(name = "data_vencimento_titulo")
    private LocalDate titleDueDate;

    @NonNull
    @Column(name = "valor_titulo")
    private BigDecimal titleValue;

    @NonNull
    @Column(name = "tipo_titulo")
    private String titleType;

    @NonNull
    @Column(name = "status_titulo")
    private String titleStatus;

    /* RELACIONAMENTOS JPA */
    @ManyToOne
    @JoinColumn(name = "id_venda_titulo")
    private SaleEntity sale;
}