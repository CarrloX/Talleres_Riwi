package database;

import java.util.List;

public interface CRUD {
    boolean create(Object object);

    List<Object> read();

    boolean update(Object object);

    boolean delete(int object);

}
