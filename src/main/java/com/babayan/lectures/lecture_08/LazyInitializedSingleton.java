package com.babayan.lectures.lecture_08;

import java.util.Scanner;

public class LazyInitializedSingleton {
    public static LazyInitializedSingleton instance;
    private int age;
    private String name;
    private LazyInitializedSingleton(int age,String name){
        this.age = age;
        this.name = name;
    }
    public static LazyInitializedSingleton getInstance(){
        if(instance==null){
            Scanner input = new Scanner(System.in);
            String name = input.nextLine();
            int age = input.nextInt();
            instance = new LazyInitializedSingleton(age,name);
        }
        return instance;
    }
    @Override
    public String toString(){
        return name + " *** " + age;
    }

    public static void main(String[] args) {
        System.out.println(System.getenv("PATH"));
//        System.out.println(LazyInitializedSingleton.getInstance());
//        System.out.println(LazyInitializedSingleton.getInstance());
    }
}
