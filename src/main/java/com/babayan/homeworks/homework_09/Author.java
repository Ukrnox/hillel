package com.babayan.homeworks.homework_09;

import lombok.*;
import java.time.LocalDate;
import java.util.Date;

@Value
@RequiredArgsConstructor(staticName = "of")
public class Author {
    String firstName;
    String lastName;
    LocalDate dateOfBirth;

    public Book setBook(String title, Date issueDate, Book.Genre genre, Long isbn) {
        return Book.of(title, this, issueDate, genre, isbn);
    }
}