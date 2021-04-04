package com.babayan.homeworks.homework_21SQL.dao;

import com.babayan.homeworks.homework_21SQL.entity.Role;

import java.sql.*;

public class RoleDao implements DAO<Role> {

    private Connection con;
    private final String ROLE_INSERT = "INSERT INTO roles (id, name, description) VALUES (?, ?, ?)";
    private final String ROLE_SELECT = "SELECT * from roles WHERE id = ?";
    private final String ROLE_UPDATE = "UPDATE roles SET name = ?, description = ? WHERE id = ?";
    private final String ROLE_DELETE = "DELETE FROM roles WHERE id = ";

    public RoleDao(Connection con) {
        this.con = con;
    }

    @Override
    public void create(Role entity) {
        try (PreparedStatement ps = con.prepareStatement(ROLE_INSERT)) {
            ps.setLong(1, entity.getId());
            ps.setString(2, entity.getName());
            ps.setString(3, entity.getDescription());

            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Role read(long id) {
        Role role = null;
        try (PreparedStatement ps = con.prepareStatement(ROLE_SELECT)) {
            ps.setLong(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                String name = rs.getString("name");
                String description = rs.getString("description");
                role = new Role(id, name, description);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return role;
    }

    @Override
    public void update(Role entity) {
        try (PreparedStatement ps = con.prepareStatement(ROLE_UPDATE)) {
            ps.setLong(3, entity.getId());
            ps.setString(1, entity.getName());
            ps.setString(2, entity.getDescription());

            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(long id) {
        try (Statement stmt = con.createStatement()) {
            stmt.execute(ROLE_DELETE + id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}