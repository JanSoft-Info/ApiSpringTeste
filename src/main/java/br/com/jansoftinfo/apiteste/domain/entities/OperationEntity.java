package br.com.jansoftinfo.apiteste.domain.entities;

import br.com.jansoftinfo.apiteste.adapter.utils.OperationStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@AllArgsConstructor
@Table(name = "operacao")
public class OperationEntity {
    @Id
    @Column(name = "id_operacao")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long operationId;

    @Column(name = "id_cliente")
    private Long customerId;

    @Column(name = "valor_operacao")
    private BigDecimal operationValue;

    @Column(name = "data_hora_operacao")
    private LocalDateTime operationDateTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_operacao")
    private OperationStatusEnum operationStatus;
}