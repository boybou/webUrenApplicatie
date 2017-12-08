package Api.persistence;

import javax.inject.Singleton;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Vincent, Wytze.
 * This class holds the connection to the database.
 */
@Singleton
public class ConnectionHolder {

    public static Connection connection;

    public ConnectionHolder(Connection connection) {
        this.connection = connection;
    }

    public static Connection getConnection() {
        return connection;
    }

    public static void closeConnection() throws SQLException {
        connection.close();
    }


}
