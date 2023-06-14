package ru.badmoon.camunda.metrics.provider.impl;

import io.micrometer.core.instrument.Tag;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import ru.badmoon.camunda.metrics.provider.ActivityTagProvider;

import java.util.List;

import static ru.badmoon.camunda.metrics.dictionary.TagKey.ACTIVITY_ID;
import static ru.badmoon.camunda.metrics.dictionary.TagKey.ACTIVITY_NAME;

/**
 * @author Anvar Khasanov
 * student of ITIS KFU
 */
public class DefaultActivityTagProvider implements ActivityTagProvider {

    @Override
    public List<Tag> getTags(DelegateExecution execution) {
        return List.of(
                ACTIVITY_ID.toTag(execution.getCurrentActivityId()),
                ACTIVITY_NAME.toTag(execution.getCurrentActivityName())
        );
    }

}
