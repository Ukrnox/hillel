package com.babaian.lectures.lecture_10;

public class Main {

    public static void main(String[] args) {
        Massenger m = new Massenger() {
            @Override
            public void sendMessage(String message) {
                System.out.println("12313213");
            }
        };
        Massenger m2 = message -> System.out.println("12313213");

        m.sendMessage("asd");

    }
}
