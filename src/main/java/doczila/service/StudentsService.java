package doczila.service;

import doczila.entity.Students;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class StudentsService {

    private static final String URL = "jdbc:postgresql://localhost:5432/doczilla";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "postgres";

    private static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<Students> getAllStudents() {
        List<Students> students = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM students";
            ResultSet resultSet = statement.executeQuery(SQL);
            while (resultSet.next()) {
                Students student = new Students();
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setSurname(resultSet.getString("surname"));
                student.setLastname(resultSet.getString("lastname"));
                student.setBirthday(resultSet.getString("birthday"));
                student.setGroup(resultSet.getString("group"));
                students.add(student);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return students;
    }

    public void insertStudent(Students student) {
        try {
            Statement statement = connection.createStatement();
            String sql = "insert into students (name, surname, lastname, birthday, \"group\") values ('"
                    + student.getName() + "', '"
                    + student.getSurname() + "', '"
                    + student.getLastname() + "', '"
                    + student.getBirthday() + "', '"
                    + student.getGroup() + "')";
            statement.executeQuery(sql);
        } catch (SQLException ignored) {
        }
    }

    public void deleteStudent(int id) {
        try {
            Statement statement = connection.createStatement();
            String SQL = "delete from students where id=" + id;
            statement.executeQuery(SQL);
        } catch (SQLException ignored) {
        }
    }
}
