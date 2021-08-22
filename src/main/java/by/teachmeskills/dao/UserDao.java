package by.teachmeskills.dao;

import by.teachmeskills.model.User;

import java.sql.*;
import java.util.List;

public class UserDao implements DAO {

    private final String URL = "jdbc:mysql://localhost:3306/ht10";
    private final String USER = "root";
    private final String PASSWORD = "2662600";

    @Override
    public void add(Object obj) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            PreparedStatement statement = connection.prepareStatement("insert into users " +
                    "(first_name, last_name, age, login, password) value (?, ?, ?, ?, ?)");
            statement.setString(1, ((User)obj).getFirstName());
            statement.setString(2, ((User)obj).getLastName());
            statement.setInt(3, ((User)obj).getAge());
            statement.setString(4, ((User)obj).getLogin());
            statement.setString(5, ((User)obj).getPassword());
            statement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Object read(int id) {
        return null;
    }

    @Override
    public List<?> readAll() {
        return null;
    }

    @Override
    public void update(int id, Object obj) {

    }

    @Override
    public void delete(int id) {

    }

    public boolean checkUser(String login, String password) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            PreparedStatement statement = connection.prepareStatement("select * from users where login = ?");
            statement.setString(1, login);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return rs.getString("password").equals(password);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public boolean checkLogin(String login) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            PreparedStatement statement = connection.prepareStatement("select * from users where login = ?");
            statement.setString(1, login);
            ResultSet rs = statement.executeQuery();
            return rs.next();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
}
