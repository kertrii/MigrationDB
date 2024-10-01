package org.example.database;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.experimental.UtilityClass;
import org.flywaydb.core.Flyway;

import java.sql.Connection;
import java.sql.SQLException;

@UtilityClass
public class Database {

    public static final String DB_URL = "jdbc:h2:~/migration_db";
    public static final String DB_USER = "sa";
    public static final String DB_PASSWORD = "";

    private static final HikariConfig config = new HikariConfig();
    static final HikariDataSource ds;

    static {
        config.setJdbcUrl( DB_URL );
        config.setUsername( DB_USER );
        config.setPassword( DB_PASSWORD );
        ds = new HikariDataSource( config );
        Flyway flyway = Flyway.configure()
                .dataSource(ds)
                .locations("db/migration")
                .load();
        flyway.migrate();
    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}
