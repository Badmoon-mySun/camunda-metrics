package ru.badmoon.camunda.metrics.listener;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.camunda.bpm.engine.impl.cfg.TransactionListener;
import org.camunda.bpm.engine.impl.cfg.TransactionState;
import org.camunda.bpm.engine.impl.context.Context;
import org.camunda.bpm.engine.impl.history.event.HistoricProcessInstanceEventEntity;
import ru.badmoon.camunda.metrics.core.MeterFactory;
import ru.badmoon.camunda.metrics.dictionary.Event;
import ru.badmoon.camunda.metrics.dictionary.Metric;
import ru.badmoon.camunda.metrics.provider.ProcessDefinitionTagProvider;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @author Anvar Khasanov
 * student of ITIS KFU
 */
@Getter
@RequiredArgsConstructor
public class ProcessMetricExecutionDurationListener implements MetricExecutionListener {

    protected final Event event;
    protected final Metric metric;
    protected final MeterFactory meterFactory;
    protected final List<ProcessDefinitionTagProvider> tagProviders;

    @Override
    public void notify(DelegateExecution execution) {
        var tags = tagProviders.stream()
                .flatMap(provider -> provider.getTags(execution).stream())
                .toList();

        var processDefinition = execution.getProcessInstanceId();
        var timer = meterFactory.buildDurationTimer(metric, tags);

        var transactionListener = (TransactionListener) commandContext -> {
            var entity = commandContext.getDbEntityManager()
                    .getCachedEntity(HistoricProcessInstanceEventEntity.class, processDefinition);

            if (Objects.nonNull(entity)) {
                var duration = entity.getDurationInMillis();

                if (Objects.nonNull(duration)) {
                    timer.record(duration, TimeUnit.MILLISECONDS);
                }
            }
        };

        Context.getCommandContext().getTransactionContext()
                .addTransactionListener(TransactionState.COMMITTED, transactionListener);
    }

}
