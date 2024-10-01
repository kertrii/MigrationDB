package org.example.database;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabasePopulateService {
    public static void main(String[] args) {
        String sqlFilePath = "sql/populate_db.sql";

        try {
            String sql = new String(Files.readAllBytes(Path.of(sqlFilePath)));
            String[] queries = sql.split(";");

            try (Connection connection = Database.getConnection();
                 Statement statement = connection.createStatement();) {

                for (String query : queries) {
                    query = query.trim();

                    if (!query.isEmpty()) {
                        statement.addBatch(query);
                    }
                }

                statement.executeBatch();
                System.out.println("Database populated");
            }
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }
}
