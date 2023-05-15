package ru.badmoon.camunda.metrics.config;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.binder.MeterBinder;
import org.camunda.bpm.engine.ProcessEngine;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import ru.badmoon.camunda.metrics.core.CamundaCoreMeterBinder;
import ru.badmoon.camunda.metrics.core.MeterFactory;
import ru.badmoon.camunda.metrics.engine.ProcessEngineQueryService;

/**
 * @author Anvar Khasanov
 * student of ITIS KFU
 */
@Configuration
public class CamundaMetricConfiguration {

    @Bean
    public MeterFactory meterFactory(@Lazy MeterRegistry meterRegistry) {
        return new MeterFactory(meterRegistry);
    }

    @Bean
    public ProcessEngineQueryService processEngineQueryService(ProcessEngine processEngine) {
        return new ProcessEngineQueryService(processEngine);
    }

    @Bean
    public MeterBinder camundaCoreMeterBinder(ProcessEngineQueryService queryService) {
        return new CamundaCoreMeterBinder(queryService);
    }

}
