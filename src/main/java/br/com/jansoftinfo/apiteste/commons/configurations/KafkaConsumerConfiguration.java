package br.com.jansoftinfo.apiteste.commons.configurations;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/*import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;*/

import java.util.HashMap;
import java.util.Map;

//@Configuration
public class KafkaConsumerConfiguration {
    /*@Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> kafkaFactory() {
        var kafkaFactory = new ConcurrentKafkaListenerContainerFactory<String, String>();
        kafkaFactory.setConsumerFactory(consumer());
        return kafkaFactory;
    }

    private ConsumerFactory<String, String> consumer() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

        return new DefaultKafkaConsumerFactory<>(props);
    }*/
}