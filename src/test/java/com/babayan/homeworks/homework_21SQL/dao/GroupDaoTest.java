package com.babayan.homeworks.homework_21SQL.dao;

import com.babayan.homeworks.homework_21SQL.entity.Group;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class GroupDaoTest {

    GroupDao gd;
    Group g1;

    @BeforeEach
    void setUp() {
        Connection con = getConnection();
        gd = new GroupDao(con);
        g1 = new Group(1, "Lunatiki", "tu-tu");
        gd.create(g1);
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
        Group result = gd.read(1);
        assertEquals(result, g1);
        gd.delete(1);
    }

    @Test
    void read() {
        Group result = gd.read(1);
        assertEquals(result, g1);
        gd.delete(1);
    }

    @Test
    void update() {
        g1.setName("Racoon");
        gd.update(g1);
        Group result = gd.read(1);
        assertEquals(result, g1);
        gd.delete(1);
    }

    @Test
    void delete() {
        gd.delete(1);
        Group result = gd.read(1);
        assertNull(result);
    }
}