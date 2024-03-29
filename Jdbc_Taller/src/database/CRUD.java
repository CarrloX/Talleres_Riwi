package database;

import entity.Autor;

import java.util.List;

public interface CRUD {
    public boolean insertAutor(Autor autor);

    public boolean updateAutor(Autor autor);

    public boolean deleteAutor (int idAutor);

    public List<Object> findAllAutores();

}
