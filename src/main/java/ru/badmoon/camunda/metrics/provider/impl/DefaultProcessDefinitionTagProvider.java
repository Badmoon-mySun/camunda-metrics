package ru.badmoon.camunda.metrics.provider.impl;

import io.micrometer.core.instrument.Tag;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.repository.ProcessDefinition;
import ru.badmoon.camunda.metrics.provider.ProcessDefinitionTagProvider;

import java.util.List;

import static ru.badmoon.camunda.metrics.dictionary.TagKey.PROCESS_KEY;
import static ru.badmoon.camunda.metrics.dictionary.TagKey.PROCESS_VERSION;

/**
 * @author Anvar Khasanov
 * student of ITIS KFU
 */
public class DefaultProcessDefinitionTagProvider implements ProcessDefinitionTagProvider {

    @Override
    public List<Tag> getProcessDefinitionTag(ProcessDefinition definition) {
        return List.of(
                PROCESS_KEY.toTag(definition.getKey()),
                PROCESS_VERSION.toTag(String.valueOf(definition.getVersion()))
        );
    }

}
