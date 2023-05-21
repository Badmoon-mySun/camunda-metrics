package ru.badmoon.camunda.metrics.engine;

import lombok.RequiredArgsConstructor;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.repository.ProcessDefinition;
import org.camunda.bpm.engine.runtime.Incident;

import java.util.List;

/**
 * @author Anvar Khasanov
 * student of ITIS KFU
 */
@RequiredArgsConstructor
public class ProcessEngineQueryService {

    private final ProcessEngine processEngine;

    public List<ProcessDefinition> getProcessDefinitions() {
        return processEngine.getRepositoryService()
                .createProcessDefinitionQuery()
                .latestVersion()
                .list();
    }

    public Double getCountOfExecutableJobs() {
        return (double) processEngine.getManagementService()
                .createJobQuery()
                .executable()
                .count();
    }

    public Double getCountOfProcessExecutableJobs(String processDefinitionId) {
        return (double) processEngine.getManagementService()
                .createJobQuery()
                .processDefinitionId(processDefinitionId)
                .executable()
                .count();
    }

    public Double getCountOfSuspendedJobs() {
        return (double) processEngine.getManagementService()
                .createJobQuery()
                .suspended()
                .count();
    }

    public Double getCountOfActiveProcessMessages(String processDefinitionId) {
        return (double) processEngine.getManagementService()
                .createJobQuery()
                .messages()
                .active()
                .processDefinitionId(processDefinitionId)
                .count();
    }

    public Double getCountOfActiveProcessTimers(String processDefinitionId) {
        return (double) processEngine.getManagementService()
                .createJobQuery()
                .timers()
                .active()
                .processDefinitionId(processDefinitionId)
                .count();
    }

    public Double getCountOfProcessInstances(String processDefinitionId) {
        return (double) processEngine.getRuntimeService()
                .createProcessInstanceQuery()
                .processDefinitionId(processDefinitionId)
                .count();
    }

    public Double getCountOfActiveProcessInstances(String processDefinitionId) {
        return (double) processEngine.getRuntimeService()
                .createProcessInstanceQuery()
                .processDefinitionId(processDefinitionId)
                .active()
                .count();
    }

    public Double getCountOfIncidentProcessInstances(String processDefinitionId) {
        return (double) processEngine.getRuntimeService()
                .createProcessInstanceQuery()
                .processDefinitionId(processDefinitionId)
                .withIncident()
                .count();
    }

    public Double getCountOfActiveProcessUserTasks(String processDefinitionId) {
        return (double) processEngine.getTaskService()
                .createTaskQuery()
                .processDefinitionId(processDefinitionId)
                .active()
                .count();
    }

    public Double getCountOfHistoricJobLog() {
        return (double) processEngine.getHistoryService()
                .createHistoricJobLogQuery()
                .count();
    }

    public Double getCountOfActiveIncident() {
        return (double) processEngine.getRuntimeService()
                .createIncidentQuery()
                .incidentType(Incident.FAILED_JOB_HANDLER_TYPE)
                .list()
                .stream()
                .map(Incident::getCauseIncidentId)
                .count();
    }

}
