package br.com.jansoftinfo.apiteste.domain.usecases;

import br.com.jansoftinfo.apiteste.adapter.in.dtos.CustomerInDTO;
import br.com.jansoftinfo.apiteste.adapter.in.mappers.CustomerInMapper;
import br.com.jansoftinfo.apiteste.adapter.out.dtos.CustomerOutDTO;
import br.com.jansoftinfo.apiteste.adapter.out.mappers.CustomerOutMapper;
import br.com.jansoftinfo.apiteste.adapter.out.repositories.CustomerRepository;
import br.com.jansoftinfo.apiteste.commons.messages.MessageFactory;
import br.com.jansoftinfo.apiteste.domain.entities.CustomerEntity;
import br.com.jansoftinfo.apiteste.domain.exceptions.ErrorDTO;
import br.com.jansoftinfo.apiteste.domain.ports.in.CustomerInPort;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerUsecase implements CustomerInPort {
    private final MessageFactory msg;
    private final CustomerInMapper mapperIn;
    private final CustomerOutMapper mapperOut;
    private final CustomerRepository repository;
    private final RedisTemplate<String, Object> redisTemplate;

    @Override
    public List<CustomerOutDTO> getCustomers() {
        return mapperOut.toDTO(repository.findAll());
    }

    @Override
    public List<CustomerOutDTO> getCustomersByType(String customerType) {
        return mapperOut.toDTO(repository.getCustomerByType(customerType));
    }

    @Override
    public ResponseEntity<?> getCustomerById(Long id) {
        var customer = findCustomerById(id);
        if (customer.isPresent())
            return new ResponseEntity<>(mapperOut.toDTO(customer.get()), HttpStatus.OK);
        else
            return new ResponseEntity<>(ErrorDTO.builder()
                    .message(msg.get("error.cliente.nao.encontrado"))
                    .build(), HttpStatus.OK);
    }

    @Override
    @Cacheable(value = "customerCache", key = "#id_cliente")
    public CustomerOutDTO getCustomerCache(Long id_cliente) {
        ResponseEntity<?> customerById = getCustomerById(id_cliente);
        return (CustomerOutDTO) customerById.getBody();
    }

    @Override
    public ResponseEntity<?> putCustomer(Long id, CustomerInDTO customerInDTO) {
        var customer = findCustomerById(id);
        if (customer.isPresent())
            return new ResponseEntity<>(
                    mapperOut.toDTO(repository.save(
                            mapperIn.toEntity(customerInDTO))), HttpStatus.OK);
        else
            return new ResponseEntity<>(ErrorDTO.builder()
                    .message(msg.get("error.cliente.nao.encontrado"))
                    .build(), HttpStatus.OK);
    }

    @Override
    public CustomerOutDTO postCustomer(CustomerInDTO customer) {
        CustomerEntity entity = mapperIn.toEntity(customer);
        return mapperOut.toDTO(repository.save(entity));
    }

    @Override
    @CachePut(value = "customerCache", key = "#customer.id_cliente")
    public CustomerInDTO postCustomerInCache(CustomerInDTO customer) {
        redisTemplate.opsForValue().set(customer.getId_cliente().toString(), customer);
        return customer;
    }

    private Optional<CustomerEntity> findCustomerById(Long id) {
         return repository.findById(id);
    }
}