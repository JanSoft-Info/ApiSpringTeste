package br.com.jansoftinfo.apiteste.adapter.in.controllers;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;

import br.com.jansoftinfo.apiteste.adapter.out.dtos.CustomerOutDTO;
import br.com.jansoftinfo.apiteste.domain.ports.in.CustomerInPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
public class CustomerControllerTest {
    @Mock
    private CustomerInPort customerInPort;

    @InjectMocks
    private CustomerController controller;

    @BeforeEach
    void setUp(WebApplicationContext context) {
        standaloneSetup(controller);
    }

    @Test
    @DisplayName("Deve retornar a lista de clientes com sucesso")
    void getCustomersSuccess() {
        List<CustomerOutDTO> customers = Arrays.asList(
                new CustomerOutDTO(1L, "52571029000127", "Mercado Livre", "J"),
                new CustomerOutDTO(2L, "80730785000197", "Lojas Americanas", "J"));
        when(customerInPort.getCustomers()).thenReturn(customers);

        given()
                .port(5001)
            .when()
                .get("/customers")
            .then()
                .statusCode(HttpStatus.OK.value())
                .body("$", hasSize(2))
                .body("[0].name", equalTo("Mercado Livre"))
                .body("[1].name", equalTo("Lojas Americanas"));
    }
}