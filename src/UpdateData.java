import com.sun.source.tree.StatementTree;
import java.sql.*;

public class UpdateData {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/nabildb";
        String user = "root";
                                                                                                        String pass = "forgetit";

        try {
            //1. get a connection to database
            Connection myConn = DriverManager.getConnection(url, user, pass);

            //2. create statement
            Statement myStmt = myConn.createStatement();

                String sql = "UPDATE student "
                        + "SET name = 'Harry Bush'"
                        + "WHERE id = 3";


            myStmt.executeUpdate(sql);
            System.out.println("Insertion Complete");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

