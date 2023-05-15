package ru.badmoon.camunda.metrics.dictionary;

import io.micrometer.core.instrument.Tag;
import lombok.AllArgsConstructor;

/**
 * @author Anvar Khasanov
 * student of ITIS KFU
 */
@AllArgsConstructor
public enum ProvidedMetricTagKey {

    // process definition
    PROCESS_KEY("process_key"),
    PROCESS_VERSION("process_version"),

    // activity
    ACTIVITY_NAME("activity_name"),
    ACTIVITY_ID("activity_id");

    private String key;

    public Tag toTag(String value) {
        return Tag.of(this.key, value);
    }

}
