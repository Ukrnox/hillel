package com.babayan.homeworks.homework_21SQL.dao;

import com.babayan.homeworks.homework_21SQL.entity.Role;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class RoleDaoTest {

    RoleDao rd;
    Role rl1;

    @BeforeEach
    void setUp() {
        Connection con = getConnection();
        rd = new RoleDao(con);
        rl1 = new Role(1, "Boss", "BigBoss");
        rd.create(rl1);

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
        Role result = rd.read(1);
        assertEquals(result, rl1);
        rd.delete(1);
    }

    @Test
    void read() {
        Role result = rd.read(1);
        assertEquals(result, rl1);
        rd.delete(1);
    }

    @Test
    void update() {
        rl1.setName("Racoon");
        rd.update(rl1);
        Role result = rd.read(1);
        assertEquals(result, rl1);
        rd.delete(1);
    }

    @Test
    void delete() {
        rd.delete(1);
        Role result = rd.read(1);
        assertNull(result);
    }
}