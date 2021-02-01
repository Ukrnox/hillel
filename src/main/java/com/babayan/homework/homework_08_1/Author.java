package com.babayan.homework.homework_08_1;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public final class Author {
    private final String firstName;
    private final String lastName;
    private final LocalDate dateOfBirth;

    private Author(String firstName, String lastName, LocalDate dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

    public Book setBook(String title, Date issueDate, Genre genre, Long isbn) {
        return new Book(title, this, issueDate, genre, isbn);
    }

    public static Author setAuthor(String firstName, String lastName, LocalDate dateOfBirth) {
        return new Author(firstName, lastName, dateOfBirth);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(firstName, author.firstName) &&
                Objects.equals(lastName, author.lastName) &&
                Objects.equals(dateOfBirth, author.dateOfBirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, dateOfBirth);
    }

    @Override
    public String toString() {
        return " Author:\n   {" +
                "\n  firstName : '" + firstName + '\'' +
                ",\n  lastName : '" + lastName + '\'' +
                ",\n  dateOfBirth : " + dateOfBirth +
                " \n   }";
    }

    public final class Book {
        private final String title;
        private final Author author;
        private final Date issueDate;
        private final Genre genre;
        private final Long isbn;

        private Book(String title, Author author, Date issueDate, Genre genre, Long isbn) {
            this.title = title;
            this.author = author;
            this.issueDate = issueDate;
            this.genre = genre;
            this.isbn = isbn;
        }


        public String getTitle() {
            return title;
        }

        public Author getAuthor() {
            return author;
        }

        public Date getIssueDate() {
            return new Date(issueDate.getTime());
        }

        public Genre getGenre() {
            return genre;
        }

        public long getIsbn() {
            return isbn;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Book book = (Book) o;
            return Objects.equals(title, book.title) &&
                    Objects.equals(author, book.author) &&
                    Objects.equals(issueDate, book.issueDate) &&
                    genre == book.genre && Objects.equals(isbn, book.isbn);
        }

        @Override
        public int hashCode() {
            return Objects.hash(title, author, issueDate, genre, isbn);
        }

        @Override
        public String toString() {
            return "Book { \n " +
                    "title : '" + title + '\'' +
                    ",\n" + author +
                    ",\n issueDate : " + issueDate +
                    ",\n genre : '" + genre +
                    "',\n isbn : " + isbn +
                    " }";
        }
    }

    public enum Genre {
        FAIRY_TALE("Fairy tale"), FANTASTIC_TALE("Fantastic tales"), MYSTIC_TALE("Mystic");
        private final String genre;

        Genre(String genre) {
            this.genre = genre;
        }

        @Override
        public String toString() {
            return genre;
        }
    }

    public static void main(String[] args) {
        Author author = Author.setAuthor("Petya","Petrenko",LocalDate.of(1988,11,5));
        Book book = author.setBook("Tril",new Date(120, Calendar.APRIL,22),Genre.FAIRY_TALE,213213L);
        System.out.println(book);
    }
}