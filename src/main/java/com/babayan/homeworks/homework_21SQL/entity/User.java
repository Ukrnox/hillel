package com.babayan.homeworks.homework_21SQL.entity;

import java.util.List;
import java.util.Objects;

public class User {
    private long id;
    private String name;
    private String login;
    private String password;
    private List<Group> groups;
    private Role role;

    public User(long id, String name, String login, String password, List<Group> groups, Role role) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.password = password;
        this.groups = groups;
        this.role = role;
    }

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

    public long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getLogin() {
        return this.login;
    }

    public String getPassword() {
        return this.password;
    }

    public List<Group> getGroups() {
        return this.groups;
    }

    public Role getRole() {
        return this.role;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof User)) return false;
        final User other = (User) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getId() != other.getId()) return false;
        final String thisName = this.getName();
        final String otherName = other.getName();
        if (!Objects.equals(thisName, otherName)) return false;
        final String thisLogin = this.getLogin();
        final String otherLogin = other.getLogin();
        if (!Objects.equals(thisLogin, otherLogin)) return false;
        final String thisPassword = this.getPassword();
        final String otherPassword = other.getPassword();
        if (!Objects.equals(thisPassword, otherPassword)) return false;
        final List<Group> thisGroups = this.getGroups();
        final List<Group> otherGroups = other.getGroups();
        if (!Objects.equals(thisGroups, otherGroups)) return false;
        final Role thisRole = this.getRole();
        final Role otherRole = other.getRole();
        return Objects.equals(thisRole, otherRole);
    }

    protected boolean canEqual(final Object other) {
        return other instanceof User;
    }

    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final long id = this.getId();
        result = result * PRIME + (int) (id >>> 32 ^ id);
        final String name = this.getName();
        result = result * PRIME + (name == null ? 43 : name.hashCode());
        final String login = this.getLogin();
        result = result * PRIME + (login == null ? 43 : login.hashCode());
        final String password = this.getPassword();
        result = result * PRIME + (password == null ? 43 : password.hashCode());
        final List<Group> groups = this.getGroups();
        result = result * PRIME + (groups == null ? 43 : groups.hashCode());
        final Role role = this.getRole();
        result = result * PRIME + (role == null ? 43 : role.hashCode());
        return result;
    }
}
