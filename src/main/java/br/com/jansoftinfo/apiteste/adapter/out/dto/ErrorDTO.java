package br.com.jansoftinfo.apiteste.adapter.out.dto;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDTO {
    private String message;
}
