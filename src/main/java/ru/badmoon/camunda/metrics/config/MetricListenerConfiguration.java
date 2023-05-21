package ru.badmoon.camunda.metrics.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.badmoon.camunda.metrics.core.MeterFactory;
import ru.badmoon.camunda.metrics.dictionary.Event;
import ru.badmoon.camunda.metrics.dictionary.Metric;
import ru.badmoon.camunda.metrics.listener.MetricExecutionCountListener;
import ru.badmoon.camunda.metrics.provider.ExecutionTagProvider;

import java.util.List;

/**
 * @author Anvar Khasanov
 * student of ITIS KFU
 */
@Configuration
@RequiredArgsConstructor
public class MetricListenerConfiguration {

    private final MeterFactory meterFactory;
    private final List<ExecutionTagProvider> executionTagProviders;

    @Bean
    public MetricExecutionCountListener endEventCountMetricExecutionListener() {
        return new MetricExecutionCountListener(Event.END, Metric.END_EVENT_COUNT, meterFactory, executionTagProviders);
    }

}
