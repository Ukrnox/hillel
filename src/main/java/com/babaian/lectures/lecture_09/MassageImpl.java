package com.babaian.lectures.lecture_09;

import lombok.Value;

@Value
public class MassageImpl implements Massenger {
    String name;
    @Override
    public void sendMessage(String message){
    }
}
