package ru.badmoon.camunda.metrics.engine;

import lombok.RequiredArgsConstructor;
import org.camunda.bpm.engine.ProcessEngine;

/**
 * @author Anvar Khasanov
 * student of ITIS KFU
 */
@RequiredArgsConstructor
public class ProcessEngineQueryService {

    private final ProcessEngine processEngine;

    public Double getCountOfExecutableJobs() {
        return (double) processEngine.getManagementService()
                .createJobQuery()
                .executable()
                .count();
    }

}
