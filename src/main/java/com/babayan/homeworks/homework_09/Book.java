package com.babayan.homeworks.homework_09;

import lombok.*;
import java.util.Date;

@Value
@RequiredArgsConstructor(staticName = "of")
public class Book {
    String title;
    Author author;
    Date issueDate;
    Genre genre;
    Long isbn;

    public Date getIssueDate() {
        return new Date(issueDate.getTime());
    }

    @AllArgsConstructor
    @ToString
    public enum Genre {
        FAIRY_TALE("Fairy tale"), FANTASTIC_TALE("Fantastic tale"), MYSTIC_TALE("Mystic tale");
        private final String genre;
    }
}
