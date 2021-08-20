package app.dao;

import app.model.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonDAO implements CRUD {

    private final String URL = "jdbc:mysql://localhost:3306/ct19";
    private final String USER = "root";
    private final String PASSWORD = "2662600";

    @Override
    public void insert(Object obj) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            PreparedStatement statement = connection.prepareStatement("insert into person (first_name, position_id) values (?, ?)");
            statement.setString(1, ((Person) obj).getFirstName());
            statement.setInt(2, ((Person) obj).getPositionId());
            statement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Object read(int id) {
        Person person = null;
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            PreparedStatement statement = connection.prepareStatement("select * from person where person_id = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                person = new Person();
                person.setId(resultSet.getInt("person_id"));
                person.setFirstName(resultSet.getString("first_name"));
                person.setPositionId(resultSet.getInt("position_id"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return person;
    }

    @Override
    public List<?> readAll() {
        List<Person> people = null;
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            people = new ArrayList<>();
            PreparedStatement statement = connection.prepareStatement("select * from person");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Person person = new Person();
                person.setId(resultSet.getInt("person_id"));
                person.setFirstName(resultSet.getString("first_name"));
                person.setPositionId(resultSet.getInt("position_id"));
                people.add(person);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return people;
    }

    @Override
    public void update(int id, Object obj) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            PreparedStatement statement = connection.prepareStatement("update person set first_name = ?, position_id = ? where person_id = ?");
            statement.setString(1, ((Person) obj).getFirstName());
            statement.setInt(2, ((Person) obj).getPositionId());
            statement.setInt(3, id);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            PreparedStatement statement = connection.prepareStatement("delete from person where person_id = ?");
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
