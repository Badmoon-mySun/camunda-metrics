package ru.badmoon.camunda.metrics.core;

import lombok.RequiredArgsConstructor;

/**
 * @author Anvar Khasanov
 * student of ITIS KFU
 */
@RequiredArgsConstructor
public enum ProvidedMetric {

    JOB_COUNT("", "");


    private final String name;
    private final String description;

}
