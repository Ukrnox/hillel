package com.babayan.homeworks;

import java.util.Calendar;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
//        Book.Author author = Book.Author.setAuthor("Sergey", "Lukyanenko", LocalDate.of(1968, 4, 11));
//        System.out.println(author);
//        Book book = author.setBook("11",new Date(77, Calendar.FEBRUARY,2), Book.Genre.FANTASTIC_TALE,123124123L);
//        System.out.println(book);
        Date date = new Date(2020,Calendar.FEBRUARY,3);
        System.out.println(date);
        Date date2 = new Date(date.getTime());
        System.out.println(date);
    }
}
