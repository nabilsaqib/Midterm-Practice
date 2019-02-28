package JDBCMethod;

import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        int id;
        String name;
        int age;

        DBConnector mySqlConnector = new DBConnector();
        List<StudentTable> studentList = new LinkedList<>();

        // Created three new student objects
        StudentTable studOne = new StudentTable(5, "'Billy'", 50);
        StudentTable studTwo = new StudentTable(6, "'Blue'", 25);
        StudentTable studThree = new StudentTable(7, "'YNM'", 22);

        // Added the three new student objects into the student list
        studentList.add(studOne);
        studentList.add(studTwo);
        studentList.add(studThree);

        try {
            // Inserting students into DB using FOR LOOP
            for (StudentTable stud : studentList) {
                id = stud.getId();
                name = stud.getName();
                age = stud.getAge();

                String sql = "INSERT INTO student(id, name, age) " +
                        "VALUES(" + id + ", " + name + ", " +  age + ");";
                mySqlConnector.executeSql(sql);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Inserted the students into the DB ...");
            mySqlConnector.closeConnections();
        }

    }

}
