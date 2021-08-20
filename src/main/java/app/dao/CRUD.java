package app.dao;

import java.util.List;

public interface CRUD {

    void insert(Object obj);

    Object read(int id);

    List<?> readAll();

    void update(int id, Object obj);

    void delete(int id);
}
