package transport.company.dao;

import java.util.List;

public interface DAO<Type> {
    Type get(long id, Class<Type> classType);
    List<Type> getAll();
    void add(Type data);
    void delete (Type data);
    void update (Type data);
}
