package ru.badmoon.camunda.metrics.engine;

import io.micrometer.core.instrument.MeterRegistry;
import lombok.RequiredArgsConstructor;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.impl.bpmn.parser.BpmnParseListener;
import org.camunda.bpm.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.camunda.bpm.engine.impl.cfg.ProcessEnginePlugin;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import ru.badmoon.camunda.metrics.listener.MetricsBpmnParseListener;

import java.util.ArrayList;

/**
 * @author Anvar Khasanov
 * student of ITIS KFU
 */
@Service
@RequiredArgsConstructor
public class CamundaMetricsProcessEnginePlugin implements ProcessEnginePlugin {

    private final MeterRegistry meterRegistry;
    private final MetricsBpmnParseListener metricsBpmnParseListener;

    @Override
    public void preInit(ProcessEngineConfigurationImpl processEngineConfiguration) {
        var preBPMNParseListeners = processEngineConfiguration.getCustomPreBPMNParseListeners();

        if (preBPMNParseListeners == null) {
            preBPMNParseListeners = new ArrayList<>();
            processEngineConfiguration.setCustomPreBPMNParseListeners(preBPMNParseListeners);
        }

        preBPMNParseListeners.add(metricsBpmnParseListener);
    }

    @Override
    public void postInit(ProcessEngineConfigurationImpl processEngineConfiguration) {

//        processEngineConfiguration.setMetricsRegistry(meterRegistry);
    }

    @Override
    public void postProcessEngineBuild(ProcessEngine processEngine) {

    }
}
