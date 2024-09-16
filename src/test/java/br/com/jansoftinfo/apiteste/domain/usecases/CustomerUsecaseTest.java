package br.com.jansoftinfo.apiteste.domain.usecases;

import br.com.jansoftinfo.apiteste.commons.enums.CustomerTypeEnum;
import br.com.jansoftinfo.apiteste.adapter.out.mappers.CustomerOutMapper;
import br.com.jansoftinfo.apiteste.adapter.out.repositories.CustomerRepository;
import br.com.jansoftinfo.apiteste.data.CustomerOutDTODataTest;
import br.com.jansoftinfo.apiteste.domain.ports.in.CustomerInPort;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CustomerUsecaseTest {
    @Mock
    private CustomerOutMapper mapperOut;
    @Mock
    private CustomerInPort customerInPort;
    @Mock
    private CustomerRepository repository;

    @InjectMocks
    private CustomerUsecase customerUsecase;

    @Test
    @DisplayName("Quando invocado deverá retornar uma lista de todos clientes")
    void getCustomersTest() {
        var clientes = CustomerOutDTODataTest.getCustomers();
        when(customerUsecase.getCustomers()).thenReturn(clientes);
        var customers = customerUsecase.getCustomers();
        assertNotNull(customers);
    }

    @Test
    @DisplayName("Quando invocado deverá retornar uma lista dos clientes por tipo informado")
    void getCustomersByType() {
        var clientes = CustomerOutDTODataTest.getCustomers();
        when(customerUsecase.getCustomersByType(CustomerTypeEnum.FISICA.getValue()))
                .thenReturn(clientes);
        var customers = customerUsecase.getCustomersByType(CustomerTypeEnum.FISICA.getValue());
        assertNotNull(customers);
    }
}