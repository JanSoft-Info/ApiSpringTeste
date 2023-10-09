package br.com.jansoftinfo.apiteste.adapter.in.controllers;

import br.com.jansoftinfo.apiteste.adapter.out.dto.SaleOutDTO;
import br.com.jansoftinfo.apiteste.adapter.utils.Constants;
import br.com.jansoftinfo.apiteste.domain.ports.in.SaleInPort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sales")
public class SaleController {
    private final SaleInPort port;

    @PostMapping(consumes = Constants.HTTP_CONTENT_TYPE, produces = Constants.HTTP_CONTENT_TYPE)
    public ResponseEntity<?> sendMessage(@RequestBody String message) {
        port.sendMessage(message);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @GetMapping(consumes = Constants.HTTP_CONTENT_TYPE, produces = Constants.HTTP_CONTENT_TYPE)
    public ResponseEntity<?> getSales() {
        return new ResponseEntity<List<SaleOutDTO>>(port.getSales(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", consumes = Constants.HTTP_CONTENT_TYPE, produces = Constants.HTTP_CONTENT_TYPE)
    public ResponseEntity<?> getSale(@PathVariable Long id) {
        return port.getSale(id);
    }

    @GetMapping(value = "/query", consumes = Constants.HTTP_CONTENT_TYPE, produces = Constants.HTTP_CONTENT_TYPE)
    public ResponseEntity<?> getSalesByStatus(@RequestParam("saleStatus") String saleStatus) {
        return new ResponseEntity<List<SaleOutDTO>>(port.getSalesByStatus(saleStatus), HttpStatus.OK);
    }

    @GetMapping(value = "/customers/{idCustomer}", consumes = Constants.HTTP_CONTENT_TYPE, produces = Constants.HTTP_CONTENT_TYPE)
    public ResponseEntity<?> getSalesByCustomerId(@PathVariable Long idCustomer) {
        return new ResponseEntity<List<SaleOutDTO>>(port.getSalesByCustomerId(idCustomer), HttpStatus.OK);
    }
}