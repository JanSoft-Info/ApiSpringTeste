package br.com.jansoftinfo.apiteste.domain.usecase;

import br.com.jansoftinfo.apiteste.adapter.in.dto.CustomerDTO;
import br.com.jansoftinfo.apiteste.domain.exceptions.ErrorDTO;
import br.com.jansoftinfo.apiteste.adapter.out.mappers.CustomerMapper;
import br.com.jansoftinfo.apiteste.adapter.out.repositories.CustomerRepository;
import br.com.jansoftinfo.apiteste.domain.entities.CustomerEntity;
import br.com.jansoftinfo.apiteste.domain.ports.in.CustomerPort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
class CustomerUsecase implements CustomerPort {
    private final CustomerMapper mapper;
    private final CustomerRepository repository;

    @Override
    public List<CustomerDTO> getCustomers() {
        return mapper.toDTO(repository.findAll());
    }

    @Override
    public List<CustomerDTO> getCustomersByType(String customerType) {
        return mapper.toDTO(repository.getCustomerByType(customerType));
    }

    @Override
    public ResponseEntity<?> getCustomer(Long id) {
        var customer = findCustomerById(id);
        if (customer.isPresent())
            return new ResponseEntity<>(mapper.toDTO(customer.get()), HttpStatus.OK);
        else
            return new ResponseEntity<>(ErrorDTO.builder()
                    .message("Cliente não encontrado")
                    .build(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> putCustomer(Long id, CustomerDTO customerDTO) {
        var customer = findCustomerById(id);
        if (customer.isPresent())
            return new ResponseEntity<>(mapper
                    .toDTO(repository.save(mapper
                            .toEntity(customerDTO))), HttpStatus.OK);
        else
            return new ResponseEntity<>(ErrorDTO.builder()
                    .message("Cliente não encontrado")
                    .build(), HttpStatus.OK);
    }

    @Override
    public CustomerDTO postCustomer(CustomerDTO customer) {
        CustomerEntity customerEntity = repository.save(mapper.toEntity(customer));
        return mapper.toDTO(customerEntity);
    }

    private Optional<CustomerEntity> findCustomerById(Long id) {
         return repository.findById(id);
    }
}