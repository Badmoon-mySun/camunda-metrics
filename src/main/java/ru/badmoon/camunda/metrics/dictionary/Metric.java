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
    JOB_HISTORIC_LOG_COUNT("camunda.job.historic.log.count", "Count of camunda job historic log"),
    INCIDENTS_COUNT("camunda.incidents.count", "Count of camunda incidents"),
    PROCESS_COUNT("camunda.process.count", "Count of started camunda process"),
    ACTIVITY_COUNT("camunda.activity.count", "Count of started camunda activity"),

    PROCESS_INSTANCES_COUNT("camunda.process.instance.count", "Count of camunda process instances"),
    PROCESS_JOB_COUNT("camunda.process.job.count", "Count of camunda process jobs"),
    PROCESS_TIMER_COUNT("camunda.process.timer.count", "Count of camunda process timers"),
    PROCESS_MESSAGE_COUNT("camunda.process.message.count", "Count of camunda process messages"),
    PROCESS_INCIDENT_COUNT("camunda.process.incident.count", "Count of camunda process incidents"),
    PROCESS_TASK_COUNT("camunda.process.task.count", "Count of camunda process user tasks"),

    PROCESS_DURATION("camunda.process.duration", "Duration of camunda process"),
    ACTIVITY_DURATION("camunda.activity.duration", "Duration of camunda activity"),
    END_EVENT_COUNT("camunda.event.end.count", "Count of end camunda events");

    private final String name;
    private final String description;

}
