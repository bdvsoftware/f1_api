package com.f1api.config.kafka.consumer;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;

@Configuration
@RequiredArgsConstructor
public class KafkaListenerContainerConfig {
    private final ConsumerFactory<String, Object> consumerFactory;
    private final EnvironmentConsumerRecordInterceptor environmentConsumerRecordInterceptor;

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Object> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, Object> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory);
        factory.setRecordInterceptor(environmentConsumerRecordInterceptor);
        return factory;
    }
}
