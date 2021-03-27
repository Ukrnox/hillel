package com.babayan.homeworks.homework_21SQL.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class User {
    private long id;
    private String name;
    private String login;
    private String password;
    private List<Group> groups;
    private Role role;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", groups=" + groups +
                ", role='" + role + '\'' +
                '}';
    }
}
