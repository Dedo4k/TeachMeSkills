package by.teachmeskills.dao;

import java.util.List;

public interface DAO {

    void add(Object obj);

    Object read(int id);

    List<?> readAll();

    void update(int id, Object obj);

    void delete(int id);
}
