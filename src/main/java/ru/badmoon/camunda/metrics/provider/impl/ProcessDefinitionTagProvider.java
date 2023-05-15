package ru.badmoon.camunda.metrics.provider.impl;

import io.micrometer.core.instrument.Tag;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import ru.badmoon.camunda.metrics.provider.ExecutionTagProvider;

import java.util.List;

import static ru.badmoon.camunda.metrics.dictionary.ProvidedMetricTagKey.PROCESS_KEY;
import static ru.badmoon.camunda.metrics.dictionary.ProvidedMetricTagKey.PROCESS_VERSION;

/**
 * @author Anvar Khasanov
 * student of ITIS KFU
 */
public class ProcessDefinitionTagProvider implements ExecutionTagProvider {

    @Override
    public List<Tag> getTags(DelegateExecution execution) {
        var definitionId = execution.getProcessDefinitionId();
        var definition = execution.getProcessEngineServices()
                .getRepositoryService().getProcessDefinition(definitionId);

        return List.of(
                PROCESS_KEY.toTag(definition.getKey()),
                PROCESS_VERSION.toTag(String.valueOf(definition.getVersion()))
        );
    }

}
