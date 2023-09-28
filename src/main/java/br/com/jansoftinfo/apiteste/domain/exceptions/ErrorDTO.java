package br.com.jansoftinfo.apiteste.domain.exceptions;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDTO {
    @JsonProperty("mensagem")
    private String message;
}
