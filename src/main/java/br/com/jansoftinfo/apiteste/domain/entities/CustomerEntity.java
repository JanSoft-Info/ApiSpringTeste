package br.com.jansoftinfo.apiteste.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cliente")
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long customerId;

    @NonNull
    @Column(name = "cpf_cnpj_cliente", unique = true)
    private String customerDocumentId;

    @NonNull
    @Column(name = "nome_cliente")
    private String customerName;

    @NonNull
    @Column(name = "tipo_cliente")
    private String customerType;

    /* RELACIONAMENTOS JPA */

    @OneToMany
    private List<SaleEntity> sales;
}