package com.f1api.config.kafka.producer;

import org.apache.kafka.clients.producer.ProducerInterceptor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@DependsOn("applicationContextProvider")
public class EnvironmentHeaderProducerInterceptor implements ProducerInterceptor<String, Object> {

    @Value("${kafka.environment}")
    private final String environment;
    public static final String ENVIRONMENT_HEADER = "environment";

    public EnvironmentHeaderProducerInterceptor() {
        // Necessary because Spring doesn't inject @Value fields when instantiated again and this class is instantiated by Kafka (reflection)
        ApplicationContext ctx = ApplicationContextProvider.getApplicationContext();
        this.environment = ctx.getEnvironment().getProperty("kafka.environment");
    }

    @Override
    public ProducerRecord<String, Object> onSend(ProducerRecord<String, Object> producerRecord) {
        producerRecord.headers().add(ENVIRONMENT_HEADER, environment.getBytes());
        return producerRecord;
    }

    @Override
    public void onAcknowledgement(RecordMetadata metadata, Exception exception) {
        // No-op
    }

    @Override
    public void close() {
        // No-op
    }

    @Override
    public void configure(Map<String, ?> configs) {
        // No-op
    }
}
