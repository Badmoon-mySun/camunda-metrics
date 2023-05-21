package ru.badmoon.camunda.metrics.core;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Tag;
import io.micrometer.core.instrument.binder.MeterBinder;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.ListUtils;
import ru.badmoon.camunda.metrics.dictionary.Metric;
import ru.badmoon.camunda.metrics.engine.ProcessEngineQueryService;
import ru.badmoon.camunda.metrics.provider.ProcessDefinitionTagProvider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.ToDoubleFunction;

import static ru.badmoon.camunda.metrics.dictionary.TagKey.METRIC_TYPE;

/**
 * @author Anvar Khasanov
 * student of ITIS KFU
 */
@RequiredArgsConstructor
public class CamundaCoreMeterBinder implements MeterBinder {

    private MeterFactory meterFactory;
    private final ProcessEngineQueryService queryService;
    private final ProcessDefinitionTagProvider processDefinitionTagProvider;

    @Override
    public void bindTo(MeterRegistry meterRegistry) {
        meterFactory = new MeterFactory(meterRegistry);

        createMetric(Metric.JOB_HISTORIC_LOG_COUNT, List.of(),
                queryService, ProcessEngineQueryService::getCountOfHistoricJobLog);
        createMetric(Metric.JOB_COUNT, List.of(METRIC_TYPE.toTag("executable")),
                queryService, ProcessEngineQueryService::getCountOfExecutableJobs);
        createMetric(Metric.JOB_COUNT, List.of(METRIC_TYPE.toTag("suspended")),
                queryService, ProcessEngineQueryService::getCountOfSuspendedJobs);

        var processDefinitionList = queryService.getProcessDefinitions();

        createMetric(Metric.PROCESS_COUNT, List.of(), processDefinitionList, List::size);
        createMetric(Metric.INCIDENTS_COUNT, List.of(), queryService,
                ProcessEngineQueryService::getCountOfActiveIncident);

        processDefinitionList.forEach(processDefinition -> {
            var processTags = processDefinitionTagProvider.getProcessDefinitionTag(processDefinition);
            var processId = processDefinition.getId();

            createMetric(Metric.PROCESS_INSTANCES_COUNT, processTags,
                    queryService, queryService -> queryService.getCountOfProcessInstances(processId));
            createMetric(Metric.PROCESS_INSTANCES_COUNT,
                    ListUtils.union(processTags, List.of(METRIC_TYPE.toTag("active"))),
                    queryService, queryService -> queryService.getCountOfActiveProcessInstances(processId));
            createMetric(Metric.PROCESS_JOB_COUNT, processTags,
                    queryService, queryService -> queryService.getCountOfProcessExecutableJobs(processId));
            createMetric(Metric.PROCESS_TASK_COUNT, processTags,
                    queryService, queryService -> queryService.getCountOfActiveProcessUserTasks(processId));
            createMetric(Metric.PROCESS_TIMER_COUNT, processTags,
                    queryService, queryService -> queryService.getCountOfActiveProcessTimers(processId));
            createMetric(Metric.PROCESS_INCIDENT_COUNT, processTags,
                    queryService, queryService -> queryService.getCountOfIncidentProcessInstances(processId));
            createMetric(Metric.PROCESS_MESSAGE_COUNT, processTags,
                    queryService, queryService -> queryService.getCountOfActiveProcessMessages(processId));
        });
    }

    public <T> void createMetric(Metric metric, List<Tag> tags, T type, ToDoubleFunction<T> func) {
        meterFactory.buildGauge(metric, tags, type, func);
    }
}
