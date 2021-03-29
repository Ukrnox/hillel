package com.babayan.homeworks.homework_21SQL.dao;

import com.babayan.homeworks.homework_21SQL.entity.Group;
import com.babayan.homeworks.homework_21SQL.entity.Role;
import com.babayan.homeworks.homework_21SQL.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class UserDaoTest {
    UserDao ud;
    RoleDao rd;
    GroupDao gd;
    Role rl1;
    Group g1;
    Group g2;
    List<Group> gl1;
    User user1;
    User user2;
    List<User> userList;

    @BeforeEach
    void setUp() {
        Connection con = getConnection();

        ud = new UserDao(con);
        rd = new RoleDao(con);
        gd = new GroupDao(con);

        rl1 = new Role(1, "Boss", "BigBoss");

        g1 = new Group(1, "Lunatiki", "tu-tu");
        g2 = new Group(2, "Footballers", "love the ball");

        gl1 = new ArrayList<>();
        gl1.add(g1);
        gl1.add(g2);

        user1 = new User(1, "Ivan1", "student1", "1", gl1, rl1);
        user2 = new User(2, "Ivan2", "student2", "2", gl1, rl1);
        userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        rd.create(rl1);
        gd.create(g1);
        gd.create(g2);
        ud.create(user1);

    }

    private static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:D:/Java/hillel/src/main/resources/test.db");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Test
    void create() {
        User read = ud.read(1);
        assertEquals(read, user1);
        ud.delete(1);
        rd.delete(1);
        gd.delete(1);
        gd.delete(2);
    }

    @Test
    void read() {
        User read = ud.read(1);
        assertEquals(read, user1);
        ud.delete(1);
        rd.delete(1);
        gd.delete(1);
        gd.delete(2);
    }

    @Test
    void update() {
        user1.setLogin("Killo");
        ud.update(user1);
        User read = ud.read(1);
        assertEquals(read, user1);
        ud.delete(1);
        rd.delete(1);
        gd.delete(1);
        gd.delete(2);
    }

    @Test
    void delete() {
        ud.delete(1);
        rd.delete(1);
        gd.delete(1);
        gd.delete(2);
        assertNull(ud.read(1));
    }

    @Test
    void readUserByRoleId() {
        ud.create(user2);
        List<User> resultUserList = ud.readUserByRoleId(1);
        assertEquals(resultUserList, userList);
        ud.delete(1);
        rd.delete(1);
        gd.delete(1);
        gd.delete(2);
        ud.delete(2);
    }

    @Test
    void getUsersByGroup() {
        ud.create(user2);
        List<User> usersByGroup = ud.getUsersByGroup(1);
        assertEquals(usersByGroup, userList);
        ud.delete(1);
        rd.delete(1);
        gd.delete(1);
        gd.delete(2);
        ud.delete(2);
    }

    @Test
    void getGroups() {
        List<Group> groups = ud.getGroups(1);
        assertEquals(groups, gl1);
        ud.delete(1);
        rd.delete(1);
        gd.delete(1);
        gd.delete(2);
        ud.delete(2);
    }
}