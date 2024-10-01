package org.example.database;

import org.example.findes_methods.LongestProject;
import org.example.findes_methods.MaxProjectCountClient;
import org.example.findes_methods.MaxSalaryWorker;
import org.example.findes_methods.YoungestOldestWorkers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {
    private String readSQLFromFile(String filePath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }

    public List<MaxProjectCountClient> findMaxProjectCountClients() {
        List<MaxProjectCountClient> maxProjectCountClients = new ArrayList<>();
        String sqlFilePath = "sql/find_max_projects_client.sql";

        try {
            String sql = readSQLFromFile(sqlFilePath);

            try (Connection connection = Database.getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(sql);
                 ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {
                    String name = resultSet.getString("NAME");
                    int projectCount = resultSet.getInt("project_count");
                    maxProjectCountClients.add(new MaxProjectCountClient(name, projectCount));
                }

            }
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }

        return maxProjectCountClients;
    }

    public List<LongestProject> findLongestProjects() {
        List<LongestProject> longestProjects = new ArrayList<>();
        String sqlFilePath = "sql/find_longest_project.sql";

        try {
            String sql = readSQLFromFile(sqlFilePath);

            try (Connection connection = Database.getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(sql);
                 ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {
                    String projectName = resultSet.getString("PROJECT_NAME");
                    int monthCount = resultSet.getInt("MONTH_COUNT");
                    longestProjects.add(new LongestProject(projectName, monthCount));
                }
            }
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }

        return longestProjects;
    }

    public List<MaxSalaryWorker> findMaxSalaryWorkers() {
        List<MaxSalaryWorker> maxSalaryWorkers = new ArrayList<>();
        String sqlFilePath = "sql/find_max_salary_worker.sql";

        try {
            String sql = readSQLFromFile(sqlFilePath);

            try (Connection connection = Database.getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(sql);
                 ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {
                    String name = resultSet.getString("NAME");
                    int salary = resultSet.getInt("SALARY");
                    maxSalaryWorkers.add(new MaxSalaryWorker(name, salary));
                }
            }
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }

        return maxSalaryWorkers;
    }

    public List<YoungestOldestWorkers> findYoungestOldestWorkers() {
        List<YoungestOldestWorkers> youngestOldestWorkers = new ArrayList<>();
        String sqlFilePath = "sql/find_youngest_eldest_workers.sql";

        try {
            String sql = readSQLFromFile(sqlFilePath);

            try (Connection connection = Database.getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(sql);
                 ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {
                    String type = resultSet.getString("TYPE");
                    String name = resultSet.getString("NAME");
                    LocalDate birthday = resultSet.getDate("birthday").toLocalDate();
                    youngestOldestWorkers.add(new YoungestOldestWorkers(type, name, birthday));
                }
            }
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }

        return youngestOldestWorkers;
    }
}
