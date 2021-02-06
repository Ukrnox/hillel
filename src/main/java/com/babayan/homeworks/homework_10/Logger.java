package com.babayan.homeworks.homework_10;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public abstract class Logger {

    private LogLevel level;

    public void log(String message) {
    }

    public void log(String message, LogLevel level) {
    }

    public void debug(String massage) {
        log(massage, LogLevel.DEBUG);
    }

    public void info(String massage) {
        log(massage, LogLevel.INFO);
    }

    public void warn(String massage) {
        log(massage, LogLevel.WARN);
    }

    public void error(String massage) {
        log(massage, LogLevel.ERROR);
    }

    public void fatal(String massage) {
        log(massage, LogLevel.FATAL);
    }

    @Override
    public String toString() {
        return "Logging level is " + level;
    }

}
