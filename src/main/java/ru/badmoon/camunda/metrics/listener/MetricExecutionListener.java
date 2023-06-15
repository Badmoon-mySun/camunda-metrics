package ru.badmoon.camunda.metrics.listener;

import org.camunda.bpm.engine.delegate.ExecutionListener;
import ru.badmoon.camunda.metrics.dictionary.Event;
import ru.badmoon.camunda.metrics.dictionary.Metric;

/**
 * @author Anvar Khasanov
 * student of ITIS KFU
 */
public interface MetricExecutionListener extends ExecutionListener {

    Event getEvent();

    Metric getMetric();

}
