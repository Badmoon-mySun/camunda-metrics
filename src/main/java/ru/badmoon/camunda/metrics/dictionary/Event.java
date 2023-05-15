package ru.badmoon.camunda.metrics.dictionary;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Anvar Khasanov
 * student of ITIS KFU
 */
@Getter
@AllArgsConstructor
public enum Event {

    START("start"), END("end"), TAKE("take");

    private String name;

}
