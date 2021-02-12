package com.babayan.homeworks.homework_10;

import lombok.Getter;
import lombok.Setter;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 * Дозаписывает в файл если уже он создан  или создает новый если его нет.
 */

@Getter
@Setter
public class FileLogger extends Logger {

    private String fileName;

    public FileLogger(LogLevel level, String fileName) {
        super(level);
        this.fileName = fileName;
    }

    @Override
    public void log(String message) {
        log(message, this.getLevel());
    }

    @Override
    public void log(String message, LogLevel level) {
        if (logLvlCheck(level)) {
            try (FileWriter writer = new FileWriter(fileName, true)) {
                writer.write(LocalDateTime.now().format(
                        DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm:ss")) +
                        " " + level + " " + message + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String toString() {
        return "FileLogger() " + super.toString() + " Logging into the file: " + fileName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FileLogger fl = (FileLogger) o;
        return Objects.equals(getLevel(), fl.getLevel()) &&
                Objects.equals(fileName, fl.fileName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLevel(), fileName);
    }
}
