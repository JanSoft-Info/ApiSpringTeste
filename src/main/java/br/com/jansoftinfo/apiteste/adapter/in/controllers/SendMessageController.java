package br.com.jansoftinfo.apiteste.adapter.in.controllers;

import br.com.jansoftinfo.apiteste.adapter.in.component.SendMessageComponent;
import br.com.jansoftinfo.apiteste.adapter.in.dtos.MessageDTO;
import br.com.jansoftinfo.apiteste.commons.Constants;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/send-message")
public class SendMessageController {
    private final SendMessageComponent component;

    @Operation(summary = Constants.POST_MESSAGE)
    @PostMapping(consumes = Constants.HTTP_CONTENT_TYPE, produces = Constants.HTTP_CONTENT_TYPE)
    public ResponseEntity<?> postMessage(@Validated @RequestBody MessageDTO message) {
        return new ResponseEntity<MessageDTO>(component.postMessage(message), HttpStatus.CREATED);
    }
}