package com.f1api.config.kafka.consumer;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.listener.RecordInterceptor;
import org.springframework.stereotype.Component;

import java.util.stream.StreamSupport;

@Component
public class EnvironmentConsumerRecordInterceptor implements RecordInterceptor<String, Object> {

    private static final String ENVIRONMENT_HEADER = "environment";
    private final String environment;
    public EnvironmentConsumerRecordInterceptor(@Value("${kafka.environment}") String environment) {
        this.environment = environment;
    }

    @Override
    public ConsumerRecord<String, Object> intercept(
            ConsumerRecord<String, Object> consumerRecord,
            Consumer<String, Object> consumer) {
        var headers = consumerRecord.headers();
        var envValue = StreamSupport.stream(headers.spliterator(), false)
                .filter(header -> header.key().equals(ENVIRONMENT_HEADER))
                .findFirst()
                .orElse(null);

        return envValue == null || !new String(envValue.value()).equals(environment) ? null : consumerRecord;
    }
}
