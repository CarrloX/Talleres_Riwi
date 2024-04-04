package model;

import database.CRUD;

import java.util.List;

public class ReservacionModel implements CRUD {
    @Override
    public Object create(Object obj) {
        return false;
    }

    @Override
    public List<Object> read() {
        return null;
    }

    @Override
    public boolean update(Object obj) {
        return false;
    }

    @Override
    public boolean delete(Object obj) {
        return false;
    }
}
