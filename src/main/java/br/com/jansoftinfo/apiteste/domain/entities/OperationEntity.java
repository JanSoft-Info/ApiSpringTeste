package br.com.jansoftinfo.apiteste.domain.entities;

import br.com.jansoftinfo.apiteste.adapter.utils.enums.OperationStatusEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
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
@Table(name = "operacao")
public class OperationEntity implements Serializable {
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

    @Column(name = "status_operacao")
    private String operationStatus;

    /* RELACIONAMENTOS JPA */

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente", insertable = false, updatable = false)
    private CustomerEntity customerEntity;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_operacao", referencedColumnName = "id_operacao", insertable = false, updatable = false)
    private List<ReceivableEntity> receivablesEntity;
}