package com.babayan.homeworks.homework_17;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

public class JsonReader {
    public static User getUser(String json) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(json, User.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
