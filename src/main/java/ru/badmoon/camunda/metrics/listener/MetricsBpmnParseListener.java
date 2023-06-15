package ru.badmoon.camunda.metrics.listener;

import org.camunda.bpm.engine.impl.bpmn.parser.AbstractBpmnParseListener;
import org.camunda.bpm.engine.impl.core.model.CoreModelElement;
import org.camunda.bpm.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.camunda.bpm.engine.impl.pvm.process.ActivityImpl;
import org.camunda.bpm.engine.impl.pvm.process.ScopeImpl;
import org.camunda.bpm.engine.impl.util.xml.Element;
import org.springframework.stereotype.Component;
import ru.badmoon.camunda.metrics.dictionary.Metric;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author Anvar Khasanov
 * student of ITIS KFU
 */
public class MetricsBpmnParseListener extends AbstractBpmnParseListener {

    private final Map<Metric, MetricExecutionListener> executionListenerMap;

    public MetricsBpmnParseListener(List<MetricExecutionListener> executionListeners) {
        executionListenerMap = executionListeners.stream()
                .collect(Collectors.toMap(MetricExecutionListener::getMetric, Function.identity()));
    }

    protected void addMetricListener(Metric metric, CoreModelElement coreModelElement) {
        var listener = executionListenerMap.get(metric);
        if (Objects.nonNull(listener)) {
            coreModelElement.addListener(listener.getEvent().getName(), listener);
        }
    }

    public void parseCallActivity(Element callActivityElement, ScopeImpl scope, ActivityImpl activity) {
        addMetricListener(Metric.ACTIVITY_DURATION, activity);
        addMetricListener(Metric.ACTIVITY_COUNT, activity);
    }

    public void parseProcess(Element processElement, ProcessDefinitionEntity processDefinition) {
        addMetricListener(Metric.PROCESS_DURATION, processDefinition);
        addMetricListener(Metric.PROCESS_COUNT, processDefinition);
    }

    public void parseServiceTask(Element serviceTaskElement, ScopeImpl scope, ActivityImpl activity) {
        addMetricListener(Metric.ACTIVITY_DURATION, activity);
        addMetricListener(Metric.ACTIVITY_COUNT, activity);
    }

    public void parseTask(Element taskElement, ScopeImpl scope, ActivityImpl activity) {
//        processDefinition.addBuiltInListener(Metric.PROCESS_DURATION, );
    }

    public void parseStartEvent(Element startEventElement, ScopeImpl scope, ActivityImpl activity) {
//        this.addListeners(activity); // TODO
    }

    public void parseExclusiveGateway(Element exclusiveGwElement, ScopeImpl scope, ActivityImpl activity) {
//        this.addListeners(activity);
    }

    public void parseInclusiveGateway(Element inclusiveGwElement, ScopeImpl scope, ActivityImpl activity) {
//        this.addListeners(activity);
    }

    public void parseParallelGateway(Element parallelGwElement, ScopeImpl scope, ActivityImpl activity) {
//        this.addListeners(activity);
    }

    public void parseScriptTask(Element scriptTaskElement, ScopeImpl scope, ActivityImpl activity) {
//        this.addListeners(activity);
    }


    public void parseBusinessRuleTask(Element businessRuleTaskElement, ScopeImpl scope, ActivityImpl activity) {
//        this.addListeners(activity);
    }



    public void parseManualTask(Element manualTaskElement, ScopeImpl scope, ActivityImpl activity) {
//        this.addListeners(activity);
    }

    public void parseUserTask(Element userTaskElement, ScopeImpl scope, ActivityImpl activity) {
//        this.addListeners(activity);
    }

    public void parseEndEvent(Element endEventElement, ScopeImpl scope, ActivityImpl activity) {
        this.addMetricListener(Metric.END_EVENT_COUNT, activity);
    }

    public void parseSubProcess(Element subProcessElement, ScopeImpl scope, ActivityImpl activity) {
//        this.addListeners(activity);
    }



    public void parseSendTask(Element sendTaskElement, ScopeImpl scope, ActivityImpl activity) {
//        this.addListeners(activity);
    }

    public void parseReceiveTask(Element receiveTaskElement, ScopeImpl scope, ActivityImpl activity) {
//        this.addListeners(activity);
    }

    public void parseEventBasedGateway(Element eventBasedGwElement, ScopeImpl scope, ActivityImpl activity) {
//        this.addListeners(activity);
    }

    public void parseTransaction(Element transactionElement, ScopeImpl scope, ActivityImpl activity) {
//        this.addListeners(activity);
    }

    public void parseIntermediateThrowEvent(Element intermediateEventElement, ScopeImpl scope, ActivityImpl activity) {
//        this.addListeners(activity);
    }

    public void parseIntermediateCatchEvent(Element intermediateEventElement, ScopeImpl scope, ActivityImpl activity) {
//        this.addListeners(activity);
    }

    public void parseBoundaryEvent(Element boundaryEventElement, ScopeImpl scopeElement, ActivityImpl activity) {
//        this.addListeners(activity);
    }

    public void parseMultiInstanceLoopCharacteristics(Element activityElement, Element multiInstanceLoopCharacteristicsElement, ActivityImpl activity) {
//        this.addListeners(activity);
    }
}
