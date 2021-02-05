package com.babayan.homeworks;

import com.babayan.homeworks.homework_09.Author;
import com.babayan.homeworks.homework_09.Book;
import lombok.SneakyThrows;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class Main {

    public Main() {
    }


    public static void main(String[] args) {
//        Book.Author author = Book.Author.setAuthor("Sergey", "Lukyanenko", LocalDate.of(1968, 4, 11));
//        System.out.println(author);
//        Book book = author.setBook("11",new Date(77, Calendar.FEBRUARY,2), Book.Genre.FANTASTIC_TALE,123124123L);
//        System.out.println(book);
//        Date date = new Date(2020,Calendar.FEBRUARY,3);
//        System.out.println(date);
//        Date date2 = new Date(date.getTime());
//        System.out.println(date);

        Author author = Author.of("Petya","Petrenko",LocalDate.of(1988,11,5));
        Book book = author.setBook("11",new Date(77, Calendar.FEBRUARY,2), Book.Genre.FANTASTIC_TALE,123124123L);

        String title = null;
        try {
            Field field = book.getClass().getDeclaredField("title");
            Field [] fields = book.getClass().getDeclaredFields();
            System.out.println(Arrays.toString(fields));
            field.setAccessible(true);
            title = (String) field.get(book);
            field.set(book, (String) "12");
            title = (String) field.get(book);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
//        System.out.println(title);
//        System.out.println(book);


    }
}
