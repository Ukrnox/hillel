package com.babayan.homeworks.homework_21SQL.dao;

import com.babayan.homeworks.homework_21SQL.entity.Group;
import com.babayan.homeworks.homework_21SQL.entity.Role;
import com.babayan.homeworks.homework_21SQL.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements DAO<User> {

    private Connection con;
    private final String USER_INSERT = "INSERT INTO users(id, name, login, password, role) VALUES (?, ?, ?, ?, ?)";
    private final String USER_SELECT = "SELECT * from users WHERE id = ?";
    private final String USER_UPDATE = "UPDATE users SET name = ? , login = ?, password = ? WHERE id = ?";
    private final String USER_DELETE = "DELETE FROM users WHERE id = ";

    private final String UG_INSERT = "INSERT INTO usersGroups (groupID, userID) VALUES (?, ?)";
    private final String UG_SELECT_USERS = "SELECT ug.userID FROM usersGroups ug WHERE groupID = ?";
    private final String UG_SELECT_GROUPS = "SELECT ug.groupID FROM usersGroups ug WHERE userID = ?";
    private final String UG_DELETE_USER = "DELETE FROM usersGroups WHERE userID = ";

    private final String USER_SELECT_BY_ROLE = "SELECT * from users WHERE role = ?";

    public UserDao(Connection con) {
        this.con = con;
    }

    @Override
    public void create(User entity) {
        try (PreparedStatement ps = con.prepareStatement(USER_INSERT)) {

            ps.setLong(1, entity.getId());
            ps.setString(2, entity.getName());
            ps.setString(3, entity.getLogin());
            ps.setString(4, entity.getPassword());
            ps.setLong(5, entity.getRole().getId());
            setUsersInUsersGroup(entity);

            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User read(long id) {
        User user = null;
        RoleDao rd = new RoleDao(con);
        try (PreparedStatement preparedStatement = con.prepareStatement(USER_SELECT)) {
            preparedStatement.setLong(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                String name = resultSet.getString("name");
                String login = resultSet.getString("login");
                String password = resultSet.getString("password");

                Role role = rd.read(resultSet.getLong("role"));
                List<Group> gl = getGroups(id);

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
        try (PreparedStatement ps = con.prepareStatement(USER_UPDATE)) {
            ps.setString(1, entity.getName());
            ps.setString(2, entity.getLogin());
            ps.setString(3, entity.getPassword());
            ps.setLong(4, entity.getId());

            deleteUserFromUsersGroups(entity.getId()); // delete connections user-group
            setUsersInUsersGroup(entity);   // set new connections user-group

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
        try (Statement stmt = con.createStatement()) {
            deleteUserFromUsersGroups(id);
            stmt.execute(USER_DELETE + id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> readUserByRoleId(long roleID) {
        List<User> users = new ArrayList<>();
        try (PreparedStatement preparedStatement = con.prepareStatement(USER_SELECT_BY_ROLE)) {
            preparedStatement.setLong(1, roleID);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    users.add(read(resultSet.getLong("id")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    private void setUsersInUsersGroup(User user) {
        List<Group> groups = user.getGroups();
        for (Group group : groups) {
            try (PreparedStatement ps = con.prepareStatement(UG_INSERT)) {
                ps.setLong(1, group.getId());
                ps.setLong(2, user.getId());
                ps.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Is this method I tried to bring the reading logic into a separate method
     * (I did not like that part of the code was repeated)
     */
    private <T> List<T> readFromUsersGroups(String sql, DAO<T> dao, List<T> list, long id, String idName) {
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setLong(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(dao.read(rs.getLong(idName)));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<User> getUsersByGroup(long groupId) {
        List<User> users = new ArrayList<>();
        readFromUsersGroups(UG_SELECT_USERS, this, users, groupId, "userID");
        return users;
    }

    public List<Group> getGroups(long userId) {
        List<Group> groups = new ArrayList<>();
        readFromUsersGroups(UG_SELECT_GROUPS, new GroupDao(con), groups, userId, "groupID");
        return groups;
    }

    private void deleteUserFromUsersGroups(long userId) {
        try (Statement stmt = con.createStatement()) {
            stmt.execute(UG_DELETE_USER + userId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}