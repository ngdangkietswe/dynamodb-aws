package dev.ngdangkietswe.dynamodbaws.domains.common;

import java.util.List;
import java.util.Optional;

/**
 * @author ngdangkietswe
 * @since 9/16/2024
 */

public interface IBaseRepository<E> {

    void save(E entity);

    List<E> findAll();

    Optional<E> findById(String id);

    void deleteById(String id);
}
