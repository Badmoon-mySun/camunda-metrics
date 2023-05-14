package ru.badmoon.camunda.metrics.listener;

import lombok.RequiredArgsConstructor;
import org.camunda.bpm.engine.impl.bpmn.parser.AbstractBpmnParseListener;
import org.camunda.bpm.engine.impl.metrics.parser.MetricsExecutionListener;
import org.camunda.bpm.engine.impl.persistence.entity.ExecutionEntity;
import org.camunda.bpm.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.camunda.bpm.engine.impl.pvm.process.ActivityImpl;
import org.camunda.bpm.engine.impl.pvm.process.ScopeImpl;
import org.camunda.bpm.engine.impl.util.xml.Element;
import org.springframework.stereotype.Component;

/**
 * @author Anvar Khasanov
 * student of ITIS KFU
 */
@Component
@RequiredArgsConstructor
public class MetricsBpmnParseListener extends AbstractBpmnParseListener {

    private final MetricExecutionListener metricExecutionListener;

    protected void addListeners(ActivityImpl activity) {
        activity.addBuiltInListener("start", metricExecutionListener);
        activity.addBuiltInListener("end", metricExecutionListener);
    }

    public void parseProcess(Element processElement, ProcessDefinitionEntity processDefinition) {
//        processDefinition.addBuiltInListener("start", ROOT_PROCESS_INSTANCE_START_COUNTER);
    }

    public void parseStartEvent(Element startEventElement, ScopeImpl scope, ActivityImpl activity) {
        this.addListeners(activity);
    }

    public void parseExclusiveGateway(Element exclusiveGwElement, ScopeImpl scope, ActivityImpl activity) {
        this.addListeners(activity);
    }

    public void parseInclusiveGateway(Element inclusiveGwElement, ScopeImpl scope, ActivityImpl activity) {
        this.addListeners(activity);
    }

    public void parseParallelGateway(Element parallelGwElement, ScopeImpl scope, ActivityImpl activity) {
        this.addListeners(activity);
    }

    public void parseScriptTask(Element scriptTaskElement, ScopeImpl scope, ActivityImpl activity) {
        this.addListeners(activity);
    }

    public void parseServiceTask(Element serviceTaskElement, ScopeImpl scope, ActivityImpl activity) {
        this.addListeners(activity);
    }

    public void parseBusinessRuleTask(Element businessRuleTaskElement, ScopeImpl scope, ActivityImpl activity) {
        this.addListeners(activity);
    }

    public void parseTask(Element taskElement, ScopeImpl scope, ActivityImpl activity) {
        this.addListeners(activity);
    }

    public void parseManualTask(Element manualTaskElement, ScopeImpl scope, ActivityImpl activity) {
        this.addListeners(activity);
    }

    public void parseUserTask(Element userTaskElement, ScopeImpl scope, ActivityImpl activity) {
        this.addListeners(activity);
    }

    public void parseEndEvent(Element endEventElement, ScopeImpl scope, ActivityImpl activity) {
        this.addListeners(activity);
    }

    public void parseSubProcess(Element subProcessElement, ScopeImpl scope, ActivityImpl activity) {
        this.addListeners(activity);
    }

    public void parseCallActivity(Element callActivityElement, ScopeImpl scope, ActivityImpl activity) {
        this.addListeners(activity);
    }

    public void parseSendTask(Element sendTaskElement, ScopeImpl scope, ActivityImpl activity) {
        this.addListeners(activity);
    }

    public void parseReceiveTask(Element receiveTaskElement, ScopeImpl scope, ActivityImpl activity) {
        this.addListeners(activity);
    }

    public void parseEventBasedGateway(Element eventBasedGwElement, ScopeImpl scope, ActivityImpl activity) {
        this.addListeners(activity);
    }

    public void parseTransaction(Element transactionElement, ScopeImpl scope, ActivityImpl activity) {
        this.addListeners(activity);
    }

    public void parseIntermediateThrowEvent(Element intermediateEventElement, ScopeImpl scope, ActivityImpl activity) {
        this.addListeners(activity);
    }

    public void parseIntermediateCatchEvent(Element intermediateEventElement, ScopeImpl scope, ActivityImpl activity) {
        this.addListeners(activity);
    }

    public void parseBoundaryEvent(Element boundaryEventElement, ScopeImpl scopeElement, ActivityImpl activity) {
        this.addListeners(activity);
    }

    public void parseMultiInstanceLoopCharacteristics(Element activityElement, Element multiInstanceLoopCharacteristicsElement, ActivityImpl activity) {
        this.addListeners(activity);
    }
}
