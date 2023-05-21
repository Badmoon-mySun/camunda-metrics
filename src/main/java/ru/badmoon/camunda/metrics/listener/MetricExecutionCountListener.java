package ru.badmoon.camunda.metrics.listener;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.springframework.stereotype.Service;
import ru.badmoon.camunda.metrics.core.MeterFactory;
import ru.badmoon.camunda.metrics.dictionary.Event;
import ru.badmoon.camunda.metrics.dictionary.Metric;
import ru.badmoon.camunda.metrics.provider.ExecutionTagProvider;

import java.util.List;

/**
 * @author Anvar Khasanov
 * student of ITIS KFU
 */
@Getter
@RequiredArgsConstructor
public class MetricExecutionCountListener implements ExecutionListener {

    protected final Event event;
    protected final Metric metric;
    protected final MeterFactory meterFactory;
    protected final List<ExecutionTagProvider> tagProviders;

    @Override
    public void notify(DelegateExecution execution) {
        var tags = tagProviders.stream()
                .flatMap(provider -> provider.getTags(execution).stream())
                .toList();
        meterFactory.buildCounter(metric, tags).increment();
    }

}
