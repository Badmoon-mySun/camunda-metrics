package ru.badmoon.camunda.metrics.listener;

import lombok.RequiredArgsConstructor;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.springframework.stereotype.Service;
import ru.badmoon.camunda.metrics.core.MeterFactory;

/**
 * @author Anvar Khasanov
 * student of ITIS KFU
 */
@Service
@RequiredArgsConstructor
public class MetricExecutionListener implements ExecutionListener {

    private final MeterFactory meterFactory;

    @Override
    public void notify(DelegateExecution delegateExecution) throws Exception {
        meterFactory.buildCounter().increment();
    }
}
