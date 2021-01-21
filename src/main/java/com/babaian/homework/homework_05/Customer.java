package com.babaian.homework.homework_05;

import java.util.Objects;

public class Customer {
    private String name;
    private int age;
    private int customerId;

    public Customer(String name, int age, int customerId) {
        this.name = name;
        this.age = age;
        this.customerId = customerId;
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

}
