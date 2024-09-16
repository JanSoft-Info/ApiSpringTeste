package br.com.jansoftinfo.apiteste.adapter.in.dtos;

import br.com.jansoftinfo.apiteste.commons.validators.CustomerTypeValidator;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerInDTO implements Serializable {
        private Long id_cliente;

        @NotNull(message = "{error.customer.cpfcnpj.null}")
        @NotBlank(message = "{error.customer.cpfcnpj.blank}")
        private String cpf_cnpj_cliente;

        @NotNull(message = "{error.customer.name.null}")
        @NotBlank(message = "{error.customer.name.blank}")
        private String nome_cliente;

        @NotNull(message = "{error.customer.type.null}")
        @NotBlank(message = "{error.customer.type.blank}")
        @CustomerTypeValidator(message = "{error.customer.type.invalid}")
        private String tipo_cliente;
}
