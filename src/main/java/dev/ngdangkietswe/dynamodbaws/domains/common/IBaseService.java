package dev.ngdangkietswe.dynamodbaws.domains.common;

import java.util.List;
import java.util.Optional;

/**
 * @author ngdangkietswe
 * @since 9/16/2024
 */

public interface IBaseService<E> {

    void save(E entity);

    void deleteById(String id);

    Optional<E> findById(String id);

    List<E> findAll();
}
