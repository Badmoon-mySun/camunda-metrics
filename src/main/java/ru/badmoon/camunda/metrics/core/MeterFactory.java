package ru.badmoon.camunda.metrics.core;

import io.micrometer.core.instrument.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.badmoon.camunda.metrics.dictionary.Metric;

import java.util.List;
import java.util.function.ToDoubleBiFunction;
import java.util.function.ToDoubleFunction;

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

    public <T> Gauge buildGauge(Metric metric, List<Tag> tags, T type, ToDoubleFunction<T> func) {
        return Gauge.builder(metric.getName(), type, func)
                .description(metric.getDescription())
                .tags(tags)
                .register(meterRegistry);
    }

    public <T> Timer buildDurationTimer(Metric metric, List<Tag> tags) {
        return Timer.builder(metric.getName())
                .description(metric.getDescription())
                .tags(tags)
                .register(meterRegistry);
    }

}
