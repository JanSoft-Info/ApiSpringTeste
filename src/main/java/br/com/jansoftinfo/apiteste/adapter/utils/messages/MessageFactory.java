package br.com.jansoftinfo.apiteste.adapter.utils.messages;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
@RequiredArgsConstructor
public class MessageFactory {
    private final MessageSource messageResource;

    public String get(String code) {
        return messageResource.getMessage(code, null, Locale.getDefault());
    }
}