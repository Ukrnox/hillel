package com.babayan.homeworks.homework_10;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum LogLevel {
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

    public int compare(LogLevel level) {  //для проверки уровня логирования. Выше = 1. Равны = 0. Ниже = -1.
        if (level.value > value) {
            return -1;
        } else if (level.value < value) {
            return 1;
        }
        return 0;
    }
}
