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
@Table(name = "recebivel")
public class ReceivableEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_recebivel")
    private Long receivableId;

    @Column(name = "id_operacao")
    private Long operationId;

    @Column(name = "id_cliente")
    private Long customerId;

    @Column(name = "data_hora_recebivel")
    private LocalDateTime receivableDateTime;

    @Column(name = "data_vencimento_recebivel")
    private LocalDate receivableDueDate;

    @Column(name = "valor_operacao")
    private BigDecimal receivableValue;

    @Column(name = "tipo_recebivel")
    private String receivableType;

    @Column(name = "status_recebivel")
    private String receivableStatus;

    // RELACIONAMENTOS \\

    @ManyToOne
    private OperationEntity operation;
}