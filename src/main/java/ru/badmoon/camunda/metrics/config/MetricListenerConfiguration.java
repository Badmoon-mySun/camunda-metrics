package ru.badmoon.camunda.metrics.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.badmoon.camunda.metrics.core.MeterFactory;
import ru.badmoon.camunda.metrics.dictionary.Event;
import ru.badmoon.camunda.metrics.dictionary.Metric;
import ru.badmoon.camunda.metrics.listener.*;
import ru.badmoon.camunda.metrics.provider.ExecutionTagProvider;
import ru.badmoon.camunda.metrics.provider.ProcessDefinitionTagProvider;

import java.util.ArrayList;
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
    public MetricsBpmnParseListener metricsBpmnParseListener(List<MetricExecutionListener> executionListeners) {
        return new MetricsBpmnParseListener(executionListeners);
    }

    @Bean
    public ActivityMetricExecutionDurationListener activityMetricExecutionDurationListener() {
        return new ActivityMetricExecutionDurationListener(
                Event.END, Metric.ACTIVITY_DURATION, meterFactory, executionTagProviders);
    }

    @Bean
    public ProcessMetricExecutionDurationListener processMetricExecutionDurationListener(
            List<ProcessDefinitionTagProvider> processDefinitionTagProviders) {
        return new ProcessMetricExecutionDurationListener(
                Event.END, Metric.PROCESS_DURATION, meterFactory, processDefinitionTagProviders);
    }

    @Bean
    public MetricExecutionCountListener endEventCountMetricExecutionListener(
            List<ProcessDefinitionTagProvider> processDefinitionTagProviders) {
        return new MetricExecutionCountListener(
                Event.END, Metric.END_EVENT_COUNT, meterFactory, new ArrayList<>(processDefinitionTagProviders));
    }

    @Bean
    public MetricExecutionCountListener startActivityCountMetricExecutionListener() {
        return new MetricExecutionCountListener(
                Event.START, Metric.ACTIVITY_COUNT, meterFactory, executionTagProviders);
    }

    @Bean
    public MetricExecutionCountListener startProcessCountMetricExecutionListener(
            List<ProcessDefinitionTagProvider> processDefinitionTagProviders) {
        return new MetricExecutionCountListener(
                Event.START, Metric.PROCESS_COUNT, meterFactory, new ArrayList<>(processDefinitionTagProviders));
    }


}
