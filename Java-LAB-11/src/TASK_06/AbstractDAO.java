package TASK_06;
import java.sql.Connection;
import java.util.List;

public abstract class AbstractDAO<T> {
    protected Connection connection;

    public AbstractDAO(Connection connection) {
        this.connection = connection;
    }

    public abstract void create(T entity);

    public abstract T read(int id);

    public abstract List<T> readAll();

    public abstract void update(T entity);

    public abstract void delete(int id);
}
