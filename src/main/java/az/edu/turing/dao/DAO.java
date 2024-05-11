package az.edu.turing.dao;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public interface DAO<T> {
    boolean save(Collection<T> t);

    Collection<T> getAll();

    void delete(long flightId);

    Optional<T> findOneBy(Predicate<T> predicate);

    Collection<T> findAllBy(Predicate<T> predicate);
}
