package com.babayan.lectures.lecture_10;

import lombok.RequiredArgsConstructor;
import lombok.Value;

@Value
@RequiredArgsConstructor
public class Person {
    String firstName;
    String lastName;
    Integer age;
    Integer height;
    Integer weight;
    String email;
}
