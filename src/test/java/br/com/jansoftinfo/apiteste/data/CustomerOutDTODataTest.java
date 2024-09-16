package br.com.jansoftinfo.apiteste.data;

import br.com.jansoftinfo.apiteste.commons.enums.CustomerTypeEnum;
import br.com.jansoftinfo.apiteste.adapter.out.dtos.CustomerOutDTO;

import java.util.ArrayList;
import java.util.List;

public class CustomerOutDTODataTest {

    public static CustomerOutDTO getCustomer() {
        return createCustomer();
    }

    public static List<CustomerOutDTO> getCustomers() {
        var clientes = new ArrayList<CustomerOutDTO>();
        clientes.add(createCustomer());
        return clientes;
    }

    private static CustomerOutDTO createCustomer() {
        return new CustomerOutDTO(
                1L,
                "80080808080",
                "CLIENTE TESTE",
                CustomerTypeEnum.FISICA.getValue()
        );
    }
}
