package ru.badmoon.camunda.metrics.dictionary;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author Anvar Khasanov
 * student of ITIS KFU
 */
@Getter
@RequiredArgsConstructor
public enum Metric {

    JOB_COUNT("camunda.job.count", "Count of camunda jobs"),
    END_EVENT_COUNT("camunda.event.end.count", "Count of end camunda events");

    private final String name;
    private final String description;

}
