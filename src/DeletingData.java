import com.sun.source.tree.StatementTree;

import java.sql.*;

public class DeletingData{
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/nabildb";
        String user = "root";
                                                                                                    String pass = "forgetit";

        try{
            //1. get a connection to database
            Connection myConn = DriverManager.getConnection(url, user, pass);

            //2. create statement
            Statement myStmt = myConn.createStatement();

            String sql = "DELETE  FROM student WHERE id=3";

            int rowsAffected = myStmt.executeUpdate(sql);

            System.out.println("Rows affected: " + rowsAffected);
            System.out.println("Delete Complete");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
