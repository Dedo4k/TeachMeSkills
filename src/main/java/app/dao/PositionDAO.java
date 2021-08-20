package app.dao;

import app.model.Position;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PositionDAO implements CRUD {

    private final String URL = "jdbc:mysql://localhost:3306/ct19";
    private final String USER = "root";
    private final String PASSWORD = "2662600";

    @Override
    public void insert(Object obj) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            PreparedStatement statement = connection.prepareStatement("insert into position (position_name, shop_id) values (?, ?)");
            statement.setString(1, ((Position) obj).getPosition());
            statement.setInt(2, ((Position) obj).getShopId());
            statement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Object read(int id) {
        Position position = null;
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            PreparedStatement statement = connection.prepareStatement("select * from position where position_id = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                position = new Position();
                position.setId(resultSet.getInt("position_id"));
                position.setPosition(resultSet.getString("position_name"));
                position.setShopId(resultSet.getInt("shop_id"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return position;
    }

    @Override
    public List<?> readAll() {
        List<Position> positions = null;
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            positions = new ArrayList<>();
            PreparedStatement statement = connection.prepareStatement("select * from position");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Position position = new Position();
                position.setId(resultSet.getInt("position_id"));
                position.setPosition(resultSet.getString("position_name"));
                position.setShopId(resultSet.getInt("shop_id"));
                positions.add(position);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return positions;
    }

    @Override
    public void update(int id, Object obj) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            PreparedStatement statement = connection.prepareStatement("update position set position_name = ?, shop_id = ? where position_id = ?");
            statement.setString(1, ((Position) obj).getPosition());
            statement.setInt(2, ((Position) obj).getShopId());
            statement.setInt(3, id);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            PreparedStatement statement = connection.prepareStatement("delete from position where position_id = ?");
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
