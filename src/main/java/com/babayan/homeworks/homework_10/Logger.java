package com.babayan.homeworks.homework_10;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public abstract class Logger {
    public static void main(String[] args) {
        System.out.println(LogLevel.ERROR.compareTo(LogLevel.INFO));
    }

    private LogLevel level;

    public abstract void log(String message);

    public abstract void log(String message, LogLevel level);

    public boolean logLvlCheck(LogLevel level) {
        return level.compareTo(this.level) >= 0;
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
