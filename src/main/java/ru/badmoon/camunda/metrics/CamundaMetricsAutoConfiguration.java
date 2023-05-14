package ru.badmoon.camunda.metrics;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import ru.badmoon.camunda.metrics.core.MeterFactory;
import ru.badmoon.camunda.metrics.engine.CamundaMetricsProcessEnginePlugin;
import ru.badmoon.camunda.metrics.listener.MetricExecutionListener;
import ru.badmoon.camunda.metrics.listener.MetricsBpmnParseListener;

@Configuration
@Import({
		MeterFactory.class,
		MetricExecutionListener.class,
		CamundaMetricsProcessEnginePlugin.class,
		MetricsBpmnParseListener.class
})
public class CamundaMetricsAutoConfiguration {

}
