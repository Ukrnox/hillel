package com.babayan.homeworks.homework_10;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class ConsoleLogger extends Logger {

    public ConsoleLogger(LogLevel level) {
        super(level);
    }

    @Override
    public void log(String message) {
        if (LogLevel.INFO.compare(this.getLevel()) >= 0) { // проверка уровня логирования
            System.out.println(LocalDateTime.now().format(
                    DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm:ss")) +
                    " " + this.getLevel() + " " + message);
        }
    }

    @Override
    public void log(String message, LogLevel level) {
        if (level.compare(this.getLevel()) >= 0) {
            System.out.println(LocalDateTime.now().format(
                    DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm:ss")) +
                    " " + level + " " + message);
        }
    }

    @Override
    public String toString() {
        return "ConsoleLogger() " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConsoleLogger cl = (ConsoleLogger) o;
        return Objects.equals(getLevel(), cl.getLevel());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLevel());
    }
}
