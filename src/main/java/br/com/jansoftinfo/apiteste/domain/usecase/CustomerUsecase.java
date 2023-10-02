package br.com.jansoftinfo.apiteste.domain.usecase;

import br.com.jansoftinfo.apiteste.adapter.in.dto.CustomerInDTO;
import br.com.jansoftinfo.apiteste.adapter.in.mappers.CustomerInMapper;
import br.com.jansoftinfo.apiteste.adapter.out.dto.CustomerOutDTO;
import br.com.jansoftinfo.apiteste.adapter.out.mappers.CustomerOutMapper;
import br.com.jansoftinfo.apiteste.adapter.out.repositories.CustomerRepository;
import br.com.jansoftinfo.apiteste.domain.entities.CustomerEntity;
import br.com.jansoftinfo.apiteste.domain.exceptions.ErrorDTO;
import br.com.jansoftinfo.apiteste.domain.ports.in.CustomerInPort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
class CustomerUsecase implements CustomerInPort {
    private final CustomerInMapper mapperIn;
    private final CustomerOutMapper mapperOut;
    private final CustomerRepository repository;

    @Override
    public List<CustomerOutDTO> getCustomers() {
        return mapperOut.toDTO(repository.findAll());
    }

    @Override
    public List<CustomerOutDTO> getCustomersByType(String customerType) {
        return mapperOut.toDTO(repository.getCustomerByType(customerType));
    }

    @Override
    public ResponseEntity<?> getCustomer(Long id) {
        var customer = findCustomerById(id);
        if (customer.isPresent())
            return new ResponseEntity<>(mapperOut.toDTO(customer.get()), HttpStatus.OK);
        else
            return new ResponseEntity<>(ErrorDTO.builder()
                    .message("Cliente não encontrado")
                    .build(), HttpStatus.OK);
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
                    .message("Cliente não encontrado")
                    .build(), HttpStatus.OK);
    }

    @Override
    public CustomerOutDTO postCustomer(CustomerInDTO customer) {
        CustomerEntity entity = mapperIn.toEntity(customer);
        CustomerEntity customerEntity = repository.save(entity);
        return mapperOut.toDTO(customerEntity);
    }

    private Optional<CustomerEntity> findCustomerById(Long id) {
         return repository.findById(id);
    }
}