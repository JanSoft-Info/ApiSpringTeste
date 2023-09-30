package br.com.jansoftinfo.apiteste.domain.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cliente")
public class CustomerEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long customerId;

    @Column(name = "cpf_cnpj", unique = true)
    private String documentId;

    @NonNull
    @Column(name = "nome_cliente")
    private String customerName;

    @Column(name = "tipo_cliente")
    private String customerType;

    /* RELACIONAMENTOS JPA */

    @OneToMany
    List<OperationEntity> operations;
}