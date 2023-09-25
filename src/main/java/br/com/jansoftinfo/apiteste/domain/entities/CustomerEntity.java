package br.com.jansoftinfo.apiteste.domain.entities;

import br.com.jansoftinfo.apiteste.adapter.utils.CustomerTypeEnum;
import lombok.*;

import javax.persistence.*;

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

    @Column(name = "cpf_cnpj", unique = true)
    private String documentId;

    @NonNull
    @Column(name = "nome_cliente")
    private String customerName;

    @Column(name = "tipo_cliente")
    @Enumerated(EnumType.STRING)
    private CustomerTypeEnum customerType;
}