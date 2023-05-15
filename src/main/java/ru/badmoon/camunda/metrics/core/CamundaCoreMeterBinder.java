package ru.badmoon.camunda.metrics.core;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Tag;
import io.micrometer.core.instrument.binder.MeterBinder;
import lombok.RequiredArgsConstructor;
import ru.badmoon.camunda.metrics.dictionary.Metric;
import ru.badmoon.camunda.metrics.engine.ProcessEngineQueryService;

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

    @Override
    public void bindTo(MeterRegistry meterRegistry) {
        meterFactory = new MeterFactory(meterRegistry);

        createMetric(Metric.JOB_COUNT, List.of(METRIC_TYPE.toTag("executable")),
                queryService, ProcessEngineQueryService::getCountOfExecutableJobs);
    }

    public <T> void createMetric(Metric metric, List<Tag> tags, T type, ToDoubleFunction<T> func) {
        meterFactory.buildGauge(metric, tags, type, func);
    }
}
