package doczila.task2.service;

import doczila.task2.entity.Students;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentsService {

    private static final String URL = "jdbc:postgresql://localhost:5432/first_db";
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
                student.setBirthday(resultSet.getDate("birthday"));
                student.setGroupNumber(resultSet.getInt("group_number"));
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
            String SQL = "INSERT INTO Students name, surname, lastname," +
                    " birthday, group_number VALUES('"
                    + student.getName() + "',"
                    + student.getSurname() + ",'"
                    + student.getLastname() + ",'"
                    + student.getBirthday() + ",'"
                    + student.getGroupNumber() + "')";
            statement.executeQuery(SQL);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void deleteStudent(int id) {
        try {
            Statement statement = connection.createStatement();
            String SQL = "DELETE FROM Students WHERE id=" + id;
            statement.executeQuery(SQL);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
