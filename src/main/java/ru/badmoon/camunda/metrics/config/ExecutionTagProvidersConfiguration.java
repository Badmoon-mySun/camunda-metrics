package ru.badmoon.camunda.metrics.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.badmoon.camunda.metrics.provider.ExecutionTagProvider;
import ru.badmoon.camunda.metrics.provider.impl.ActivityTagProvider;
import ru.badmoon.camunda.metrics.provider.impl.ProcessDefinitionTagProvider;

/**
 * @author Anvar Khasanov
 * student of ITIS KFU
 */
@Configuration
public class ExecutionTagProvidersConfiguration {

    @Bean
    public ExecutionTagProvider activityTagProvider() {
        return new ActivityTagProvider();
    }

    @Bean
    public ExecutionTagProvider processDefinitionTagProvider() {
        return new ProcessDefinitionTagProvider();
    }

}
