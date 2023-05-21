package ru.badmoon.camunda.metrics;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import ru.badmoon.camunda.metrics.config.CamundaMetricConfiguration;
import ru.badmoon.camunda.metrics.config.ExecutionTagProvidersConfiguration;
import ru.badmoon.camunda.metrics.config.MetricListenerConfiguration;
import ru.badmoon.camunda.metrics.engine.CamundaMetricsProcessEnginePlugin;
import ru.badmoon.camunda.metrics.listener.MetricsBpmnParseListener;

@Configuration
@Import({
		CamundaMetricsProcessEnginePlugin.class,
		MetricsBpmnParseListener.class,
		ExecutionTagProvidersConfiguration.class,
		MetricListenerConfiguration.class,
		CamundaMetricConfiguration.class
})
public class CamundaMetricsAutoConfiguration {

}
