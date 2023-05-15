package ru.badmoon.camunda.metrics.provider;

import io.micrometer.core.instrument.Tag;
import org.camunda.bpm.engine.delegate.DelegateExecution;

import java.util.List;

/**
 * @author Anvar Khasanov
 * student of ITIS KFU
 */
public interface ExecutionTagProvider {

    List<Tag> getTags(DelegateExecution execution);

}
