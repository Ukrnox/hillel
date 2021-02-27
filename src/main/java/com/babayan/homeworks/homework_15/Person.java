package com.babayan.homeworks.homework_15;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import java.io.Serializable;

@Builder
@Value
@RequiredArgsConstructor
public class Person implements Serializable {
    String firstName;
    String lastName;
    Integer age;
    Integer height;
    Integer weight;
    String email;
}
