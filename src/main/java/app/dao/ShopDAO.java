package app.dao;

import app.model.Shop;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ShopDAO implements CRUD {

    private final String URL = "jdbc:mysql://localhost:3306/ct19";
    private final String USER = "root";
    private final String PASSWORD = "2662600";

    @Override
    public void insert(Object obj) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            PreparedStatement statement = connection.prepareStatement("insert into shop (shop_name) values (?)");
            statement.setString(1, ((Shop) obj).getTitle());
            statement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Object read(int id) {
        Shop shop = null;
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            PreparedStatement statement = connection.prepareStatement("select * from shop where shop_id = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                shop = new Shop();
                shop.setId(resultSet.getInt("shop_id"));
                shop.setTitle(resultSet.getString("shop_name"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return shop;
    }

    @Override
    public List<?> readAll() {
        List<Shop> shops = null;
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            shops = new ArrayList<>();
            PreparedStatement statement = connection.prepareStatement("select * from shop");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Shop shop = new Shop();
                shop.setId(resultSet.getInt("shop_id"));
                shop.setTitle(resultSet.getString("shop_name"));
                shops.add(shop);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return shops;
    }

    @Override
    public void update(int id, Object obj) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            PreparedStatement statement = connection.prepareStatement("update shop set shop_name = ? where shop_id = ?");
            statement.setString(1, ((Shop) obj).getTitle());
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            PreparedStatement statement = connection.prepareStatement("delete from shop where shop_id = ?");
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
