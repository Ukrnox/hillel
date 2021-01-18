package com.babaian.homework.homework_05;

import java.util.Objects;

public class Customer {
    private String name;
    private int age;
    private static int id;
    private int customerId;

    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
        id++;
        this.customerId = id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "'" + name + '\'' +
                ", age=" + age +
                ", Id=" + customerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return age == customer.age && customerId == customer.customerId && name.equals(customer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, customerId);
    }

    public static void main(String[] args) {
        Customer customer1 = new Customer("Vasya", 18);
        Customer customer2 = new Customer("Vasya", 18);
        Customer customer3 = new Customer("Vasya", 18);
        System.out.println(customer1);
        System.out.println(customer2);
        System.out.println(customer3.customerId);
        System.out.println(customer1.customerId);
    }
}
