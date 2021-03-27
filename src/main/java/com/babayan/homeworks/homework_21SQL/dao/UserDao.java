package com.babayan.homeworks.homework_21SQL.dao;

import com.babayan.homeworks.homework_21SQL.entity.Group;
import com.babayan.homeworks.homework_21SQL.entity.Role;
import com.babayan.homeworks.homework_21SQL.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class UserDao implements DAO<User> {

    private Connection con;
    private final String USER_INSERT = "INSERT INTO users(id, name, login, password, role) VALUES (?, ?, ?, ?, ?)";
    private final String USER_SELECT = "SELECT * from users WHERE id = ?";
    private final String USER_UPDATE = "UPDATE users SET name = ? , login = ?, password = ? WHERE id = ?";
    private final String USER_DELETE = "DELETE FROM users WHERE id = ";

    public UserDao(Connection con) {
        this.con = con;
    }

    @Override
    public void create(User entity) {
        UsersGroupsDao ugd = new UsersGroupsDao(con);
        try (PreparedStatement ps = con.prepareStatement(USER_INSERT)) {

            ps.setLong(1, entity.getId());
            ps.setString(2, entity.getName());
            ps.setString(3, entity.getLogin());
            ps.setString(4, entity.getPassword());
            ps.setLong(5, entity.getRole().getId());
            ugd.setUsers(entity);

            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User read(long id) {
        User user = null;
        RoleDao rd = new RoleDao(con);
        UsersGroupsDao ugd = new UsersGroupsDao(con);
        try (PreparedStatement preparedStatement = con.prepareStatement(USER_SELECT)) {
            preparedStatement.setLong(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                String name = resultSet.getString("name");
                String login = resultSet.getString("login");
                String password = resultSet.getString("password");

                Role role = rd.read(resultSet.getLong("role"));
                List<Group> gl = ugd.getGroups(id);

                user = new User(id, name, login, password, gl, role);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    /**
     * To update its groups, this method first removes all user-group connections and then writes new ones.
     */
    @Override
    public void update(User entity) {
        UsersGroupsDao ugd = new UsersGroupsDao(con);
        try (PreparedStatement ps = con.prepareStatement(USER_UPDATE)) {
            ps.setString(1, entity.getName());
            ps.setString(2, entity.getLogin());
            ps.setString(3, entity.getPassword());
            ps.setLong(4, entity.getId());

            ugd.deleteUser(entity.getId()); // delete connections user-group
            ugd.setUsers(entity);   // set new connections user-group

            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * First, it removes all group connections with this user, and then the user.
     */
    @Override
    public void delete(long id) {
        UsersGroupsDao ugd = new UsersGroupsDao(con);
        try (Statement stmt = con.createStatement()) {
            ugd.deleteUser(id);
            stmt.execute(USER_DELETE + id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}