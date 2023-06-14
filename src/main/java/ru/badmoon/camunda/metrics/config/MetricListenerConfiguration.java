package ru.badmoon.camunda.metrics.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.badmoon.camunda.metrics.core.MeterFactory;
import ru.badmoon.camunda.metrics.dictionary.Event;
import ru.badmoon.camunda.metrics.dictionary.Metric;
import ru.badmoon.camunda.metrics.listener.ActivityMetricExecutionDurationListener;
import ru.badmoon.camunda.metrics.listener.MetricExecutionCountListener;
import ru.badmoon.camunda.metrics.listener.MetricsBpmnParseListener;
import ru.badmoon.camunda.metrics.listener.ProcessMetricExecutionDurationListener;
import ru.badmoon.camunda.metrics.provider.ExecutionTagProvider;
import ru.badmoon.camunda.metrics.provider.ProcessDefinitionTagProvider;

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
    // TODO conditional of any Camunda metric
    public MetricsBpmnParseListener metricsBpmnParseListener(List<MetricExecutionCountListener> executionListeners) {
        return new MetricsBpmnParseListener(executionListeners);
    }

    @Bean
    public ActivityMetricExecutionDurationListener activityMetricExecutionDurationListener() {
        return new ActivityMetricExecutionDurationListener(
                Event.START, Metric.ACTIVITY_DURATION, meterFactory, executionTagProviders);
    }

    @Bean
    public ProcessMetricExecutionDurationListener processMetricExecutionDurationListener(
            List<ProcessDefinitionTagProvider> processDefinitionTagProviders) {
        return new ProcessMetricExecutionDurationListener(
                Event.START, Metric.PROCESS_DURATION, meterFactory, processDefinitionTagProviders);
    }

    @Bean
    public MetricExecutionCountListener endEventCountMetricExecutionListener() {
        return new MetricExecutionCountListener(
                Event.END, Metric.END_EVENT_COUNT, meterFactory, executionTagProviders);
    }

    @Bean
    public MetricExecutionCountListener startActivityCountMetricExecutionListener() {
        return new MetricExecutionCountListener(
                Event.START, Metric.ACTIVITY_COUNT, meterFactory, executionTagProviders);
    }

    @Bean
    public MetricExecutionCountListener startProcessCountMetricExecutionListener() {
        return new MetricExecutionCountListener(
                Event.START, Metric.PROCESS_COUNT, meterFactory, executionTagProviders);
    }


}
