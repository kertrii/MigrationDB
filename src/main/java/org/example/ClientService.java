package org.example;

import org.example.database.Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientService {

    public long create(String name) throws SQLException {
        validateName(name);

        resetClientSeq();

        String sql = "INSERT INTO client(id, name) VALUES (nextval('client_seq'), ?)";
        long generatedId = -1;

        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, name);

            int affectedRows = statement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating client failed, no rows affected.");
            }

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    generatedId = generatedKeys.getLong(1);
                } else {
                    throw new SQLException("Creating client failed, no ID obtained.");
                }
            }
        }

        return generatedId;
    }

    public String getById(long id) throws SQLException {
        validateId(id);
        String sql = "SELECT name FROM client WHERE id = ?";

        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getString("name");
                } else {
                    throw new SQLException("Client with id " + id + " not found.");
                }
            }
        }
    }

    public void setName(long id, String name) throws SQLException {
        validateId(id);
        validateName(name);
        String sql = "UPDATE client SET name = ? WHERE id = ?";

        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, name);
            statement.setLong(2, id);

            int affectedRows = statement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Updating client failed, client with id " + id + " not found.");
            }
        }
    }

    public void deleteById(long id) throws SQLException {
        String sql = "DELETE FROM client WHERE id = ?";

        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setLong(1, id);

            int affectedRows = statement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Deleting client failed, client with ID " + id + " not found.");
            }
        }
    }

    public List<Client> listAll() throws SQLException {
        List<Client> clients = new ArrayList<>();
        String sql = "SELECT * FROM client";

        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                clients.add(new Client(id, name));
            }
        }

        return clients;
    }

    private void validateName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (name.length() < 2 || name.length() > 1000) {
            throw new IllegalArgumentException("Name length must be between 2 and 1000");
        }
    }

    private void validateId(long id) {
        if (id <= 0) {
            throw new IllegalArgumentException("Id cannot be null or negative");
        }
    }

    private void resetClientSeq() throws SQLException {
        String getMaxIdSql = "SELECT COALESCE(MAX(ID), 0) FROM client";
        String resetSeqSql = "ALTER SEQUENCE client_seq RESTART WITH ?";

        try (Connection connection = Database.getConnection();
             PreparedStatement getMaxIdStmt = connection.prepareStatement(getMaxIdSql);
             PreparedStatement resetSeqStmt = connection.prepareStatement(resetSeqSql)) {

            long maxId = -1;
            try (ResultSet rs = getMaxIdStmt.executeQuery()) {
                if (rs.next()) {
                    maxId = rs.getLong(1);
                }
            }

            resetSeqStmt.setLong(1, maxId + 1);
            resetSeqStmt.executeUpdate();
        }
    }
}