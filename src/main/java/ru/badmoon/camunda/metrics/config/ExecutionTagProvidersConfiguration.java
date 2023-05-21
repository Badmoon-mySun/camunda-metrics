package ru.badmoon.camunda.metrics.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.badmoon.camunda.metrics.provider.ActivityTagProvider;
import ru.badmoon.camunda.metrics.provider.ProcessDefinitionTagProvider;
import ru.badmoon.camunda.metrics.provider.impl.DefaultActivityTagProvider;
import ru.badmoon.camunda.metrics.provider.impl.DefaultProcessDefinitionTagProvider;

/**
 * @author Anvar Khasanov
 * student of ITIS KFU
 */
@Configuration
public class ExecutionTagProvidersConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public ActivityTagProvider activityTagProvider() {
        return new DefaultActivityTagProvider();
    }

    @Bean
    @ConditionalOnMissingBean
    public ProcessDefinitionTagProvider processDefinitionTagProvider() {
        return new DefaultProcessDefinitionTagProvider();
    }

}
