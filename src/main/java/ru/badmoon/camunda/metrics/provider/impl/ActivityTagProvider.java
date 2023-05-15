package ru.badmoon.camunda.metrics.provider.impl;

import io.micrometer.core.instrument.Tag;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import ru.badmoon.camunda.metrics.provider.ExecutionTagProvider;

import java.util.List;

import static ru.badmoon.camunda.metrics.dictionary.ProvidedMetricTagKey.ACTIVITY_ID;
import static ru.badmoon.camunda.metrics.dictionary.ProvidedMetricTagKey.ACTIVITY_NAME;

/**
 * @author Anvar Khasanov
 * student of ITIS KFU
 */
public class ActivityTagProvider implements ExecutionTagProvider {

    @Override
    public List<Tag> getTags(DelegateExecution execution) {
        return List.of(
                ACTIVITY_ID.toTag(execution.getCurrentActivityId()),
                ACTIVITY_NAME.toTag(execution.getCurrentActivityName())
        );
    }

}