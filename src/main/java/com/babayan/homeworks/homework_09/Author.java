package com.babayan.homeworks.homework_09;

import lombok.*;

import java.time.LocalDate;
import java.util.Date;

/**
 *  Пойдет ли такая реализация , когда Inner class Book внутри Author ?
 *  @see Author#setBook(String, Date, Genre, Long) возвращает обьект книги из обьекта автора.
 *
 *  Пример:
 *   Author author = Author.of(...);
 *   Author.Book book = author.setBook(...);
 *
 *  Получается у автора может быть много книг и без экземпляра автора книгу не создать.
 */

@Value
@RequiredArgsConstructor(staticName = "of")
public class Author {
    String firstName;
    String lastName;
    LocalDate dateOfBirth;

    public Book setBook(String title, Date issueDate, Genre genre, Long isbn) {
        return new Book(title, this, issueDate, genre, isbn);
    }

    @Value
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public class Book {
        String title;
        Author author;
        Date issueDate;
        Genre genre;
        Long isbn;

        public Date getIssueDate() {
            return new Date(issueDate.getTime());
        }

    }
    @ToString
    public enum Genre {
        FAIRY_TALE("Fairy tale"), FANTASTIC_TALE("Fantastic tale"), MYSTIC_TALE("Mystic tale");
        private final String genre;
        Genre(String genre) {
            this.genre = genre;
        }
    }
}