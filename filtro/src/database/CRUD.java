package database;

import java.util.List;

public interface CRUD {
    Object create(Object obj);

    List<Object> read();

    boolean update(Object obj);

    boolean delete(Object obj);

}
