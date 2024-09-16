package br.com.jansoftinfo.apiteste.commons.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.util.Locale;

@Configuration
public class MessageConfiguration {
    @Bean
    public ResourceBundleMessageSource messageSource() {
        var source = new ResourceBundleMessageSource();
        source.setBasename("messages");
        source.setDefaultLocale(new Locale("pt-BR"));
        source.setUseCodeAsDefaultMessage(true);
        return source;
    }
}