package com.babayan.homeworks.homework_16;

import lombok.extern.slf4j.Slf4j;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Slf4j
public class TestRunner {
    public static void main(String[] args) {
        try {
            Class<?> aClass = Class.forName("com.babayan.homeworks.homework_16.FractionNumberTest");
            Method[] declaredMethods = aClass.getDeclaredMethods();
            for (Method method:declaredMethods) {
                if (method.isAnnotationPresent(MyTest.class)){
                    String name = method.getName();
                    log.debug(name);
                    try {
                        method.invoke(null);
                        log.debug(name+" "+"done!");
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                        log.debug(name+" "+"failed!");
                    }
                }
            }
        } catch (ClassNotFoundException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}