package com.babayan.homeworks.homework_21SQL.dao;

import com.babayan.homeworks.homework_21SQL.entity.Group;

import java.sql.*;

public class GroupDao implements DAO<Group> {
    private Connection con;
    private final String GROUP_INSERT = "INSERT INTO groups (id, name, description) VALUES (?, ?, ?)";
    private final String GROUP_SELECT = "SELECT * FROM groups WHERE id = ?";
    private final String GROUP_UPDATE = "UPDATE groups SET name = ?, description = ? WHERE id = ?";
    private final String GROUP_DELETE = "DELETE FROM groups WHERE id = ";

    public GroupDao(Connection con) {
        this.con = con;
    }

    @Override
    public void create(Group entity) {
        try (PreparedStatement ps = con.prepareStatement(GROUP_INSERT)) {
            ps.setLong(1, entity.getId());
            ps.setString(2, entity.getName());
            ps.setString(3, entity.getDescription());

            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Group read(long id) {
        Group group = null;

        try (PreparedStatement ps = con.prepareStatement(GROUP_SELECT)) {
            ps.setLong(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                String name = rs.getString("name");
                String description = rs.getString("description");
                group = new Group(id, name, description);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return group;
    }

    @Override
    public void update(Group entity) {
        try (PreparedStatement ps = con.prepareStatement(GROUP_UPDATE)) {
            ps.setString(1, entity.getName());
            ps.setString(2, entity.getDescription());
            ps.setLong(3, entity.getId());

            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * First, in this method removes all user connections with this group, and then the group.
     */
    @Override
    public void delete(long groupId) {
        UsersGroupsDao ug = new UsersGroupsDao(con);
        try (Statement stmt = con.createStatement()) {
            ug.deleteGroup(groupId);
            stmt.execute(GROUP_DELETE + groupId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}