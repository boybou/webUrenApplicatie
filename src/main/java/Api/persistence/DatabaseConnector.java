package Api.persistence;

import javax.inject.Singleton;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Vincent, Wytze.
 * This class makes the connection to the database.
 */
@Singleton
public class DatabaseConnector {

    private Connection connection;
    private String username = "postgres";
    private String password = "postgres";
    private String url = "jdbc:postgresql://localhost:5432/webeduurendatabase";

    public DatabaseConnector() {

        try {

            Class.forName("org.postgresql.Driver");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            ConnectionHolder connectionHolder = new ConnectionHolder(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }




    }
}
