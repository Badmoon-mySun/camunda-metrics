package ru.badmoon.camunda.metrics.provider;

import io.micrometer.core.instrument.Tag;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.repository.ProcessDefinition;

import java.util.List;

/**
 * @author Anvar Khasanov
 * student of ITIS KFU
 */
public interface ProcessDefinitionTagProvider extends ExecutionTagProvider {

    @Override
    default List<Tag> getTags(DelegateExecution execution) {
        var definitionId = execution.getProcessDefinitionId();
        var definition = execution.getProcessEngineServices()
                .getRepositoryService().getProcessDefinition(definitionId);

        return getProcessDefinitionTag(definition);
    }

    List<Tag> getProcessDefinitionTag(ProcessDefinition processDefinition);

}
