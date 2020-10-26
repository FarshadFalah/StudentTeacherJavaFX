package model.database;


import java.util.List;

public interface DAO<T,ID> {
    List<T> getAll();
    T getOne(ID id);
    void save(T t);
    void delete(T t);
}
