package br.com.jansoftinfo.apiteste.adapter.in.kafka;

//import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    //@KafkaListener(topics = "api.spring.teste.topic", groupId = "ApiSpringTeste-groupId")
    public void listen(String message) {
        System.out.println(message);
    }
}