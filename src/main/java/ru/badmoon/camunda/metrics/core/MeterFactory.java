package ru.badmoon.camunda.metrics.core;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Anvar Khasanov
 * student of ITIS KFU
 */
@Service
@RequiredArgsConstructor
public class MeterFactory {

    private final MeterRegistry meterRegistry;

    public Counter buildCounter() {
        return Counter.builder("bpm.camunda.metric.end.count")
                .description("description")
                .tags(List.of())
                .register(meterRegistry);
    }

}
