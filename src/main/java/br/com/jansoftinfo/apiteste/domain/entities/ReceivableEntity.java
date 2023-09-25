package br.com.jansoftinfo.apiteste.domain.entities;

import br.com.jansoftinfo.apiteste.adapter.utils.ReceivableTypeEnum;
import br.com.jansoftinfo.apiteste.adapter.utils.ReceivableStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@AllArgsConstructor
@Table(name = "recebivel")
public class ReceivableEntity {
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

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_recebivel")
    private ReceivableTypeEnum receivableType;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_recebivel")
    private ReceivableStatusEnum receivableStatus;
}