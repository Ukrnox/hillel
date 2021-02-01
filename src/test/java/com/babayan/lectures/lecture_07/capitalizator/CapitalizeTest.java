package com.babayan.lectures.lecture_07.capitalizator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CapitalizeTest {

    InputGetter getter = Mockito.mock(InputGetter.class);

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

//    @Mock
//    Scanner scanner;

    @Test
    void getUpperCaseInput() {
        var capitalazer = new Capitalize (getter);
        Mockito.when(getter.get()).thenReturn("upper");
        String upperCaseInput = capitalazer.getUpperCaseInput();
        Assertions.assertEquals("UPPER",upperCaseInput);
    }
}