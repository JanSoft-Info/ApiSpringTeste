package br.com.jansoftinfo.apiteste.adapter.in.controllers;

import br.com.jansoftinfo.apiteste.adapter.in.dto.OperationDTO;
import br.com.jansoftinfo.apiteste.domain.ports.in.OperationPort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/operations")
public class OperationController {
    private final OperationPort port;

    @GetMapping
    public ResponseEntity<?> getOperations() {
        return new ResponseEntity<List<OperationDTO>>(port.getOperations(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOperation(@PathVariable Long id) {
        return port.getOperation(id);
    }

    @GetMapping("/query")
    public ResponseEntity<?> getOperationsByStatus(@RequestParam("operationStatus") String operationStatus) {
        return new ResponseEntity<List<OperationDTO>>(port.getOperationsByStatus(operationStatus), HttpStatus.OK);
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity<?> getOperationsByCustomerId(@PathVariable Long id) {
        return new ResponseEntity<List<OperationDTO>>(port.getOperationsByCustomerId(id), HttpStatus.OK);
    }
}