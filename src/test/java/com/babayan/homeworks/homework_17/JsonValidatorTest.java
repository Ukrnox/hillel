package com.babayan.homeworks.homework_17;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JsonValidatorTest {

    @Test
    void isValid() {
        String testTrue = "{awdawd}{aaa}{d2}{123}";
        String testFalse = "{14}}aadwa}{da{ad{";
        assertTrue(JsonValidator.isValid(testTrue));
        assertFalse(JsonValidator.isValid(testFalse));
    }
}