package dev.ngdangkietswe.dynamodbaws.domains.common.services;

import java.util.List;

/**
 * @author ngdangkietswe
 * @since 9/16/2024
 */

public interface IBaseService<D> {

    String save(D dto);

    void deleteById(String id);

    D findById(String id);

    List<D> findAll();
}
