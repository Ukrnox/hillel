package com.babayan.homeworks.homework_21SQL.dao;

import com.babayan.homeworks.homework_21SQL.entity.Group;
import com.babayan.homeworks.homework_21SQL.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsersGroupsDao {

    private Connection con;
    private final String UG_INSERT = "INSERT INTO usersGroups (groupID, userID) VALUES (?, ?)";
    private final String UG_SELECT_USERS = "SELECT * FROM usersGroups WHERE groupID = ?";
    private final String UG_SELECT_GROUPS = "SELECT * FROM usersGroups WHERE userID = ?";
    private final String UG_DELETE_USER = "DELETE FROM usersGroups WHERE userID = ";
    private final String UG_DELETE_GROUP = "DELETE FROM usersGroups WHERE groupID = ";


    public UsersGroupsDao(Connection con) {
        this.con = con;
    }

    public void setUsers(User user) {
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
    private <T> List<T> read(String sql, DAO<T> dao, List<T> list, long id, String idName) {
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

    public List<User> getUsers(long groupId) {
        List<User> users = new ArrayList<>();
        read(UG_SELECT_USERS, new UserDao(con), users, groupId, "userID");
        return users;
    }

    public List<Group> getGroups(long userId) {
        List<Group> groups = new ArrayList<>();
        read(UG_SELECT_GROUPS, new GroupDao(con), groups, userId, "groupID");
        return groups;
    }

    private void delete(String deleteSql) {
        try (Statement stmt = con.createStatement()) {
            stmt.execute(deleteSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(long userId) {
        delete(UG_DELETE_USER + userId);
    }

    public void deleteGroup(long groupId) {
        delete(UG_DELETE_GROUP + groupId);
    }
}