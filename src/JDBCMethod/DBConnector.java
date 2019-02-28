package JDBCMethod;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnector extends DBProperties{
    private Connection conn = null;
    private Statement stmt = null;

    public DBConnector() {
        try {
            // 1. Get a connection to the database
            this.conn = DriverManager.getConnection(this.url, this.user, this.pass);
            // 2. Create a statement
            this.stmt = this.conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void executeSql(String sql) {
        try {
            // Execute the SQL query
            this.stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnections() {
        try {
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
