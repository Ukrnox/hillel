package com.babayan.homeworks.homework_10;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum LogLevel implements Comparable<LogLevel> {
    ALL("ALL.", 1),
    DEBUG("DEBUG:", 2),
    INFO("INFO:", 3),
    WARN("WARN:", 4),
    ERROR("ERROR:", 5),
    FATAL("FATAL:", 6),
    OFF("OFF.", 7);

    private final String name;
    private final int value;

    @Override
    public String toString() {
        return this.name;
    }
}
