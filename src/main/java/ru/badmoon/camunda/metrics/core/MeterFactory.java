package ru.badmoon.camunda.metrics.core;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.badmoon.camunda.metrics.dictionary.Metric;

import java.util.List;

/**
 * @author Anvar Khasanov
 * student of ITIS KFU
 */
@Service
@RequiredArgsConstructor
public class MeterFactory {

    private final MeterRegistry meterRegistry;

    public Counter buildCounter(Metric metric, List<Tag> tags) {
        return Counter.builder(metric.getName())
                .description(metric.getDescription())
                .tags(tags)
                .register(meterRegistry);
    }

}
