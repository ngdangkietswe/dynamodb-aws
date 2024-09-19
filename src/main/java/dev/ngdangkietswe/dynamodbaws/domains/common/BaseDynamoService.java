package dev.ngdangkietswe.dynamodbaws.domains.common;

import java.util.List;
import java.util.Optional;

/**
 * @author ngdangkietswe
 * @since 9/16/2024
 */

public abstract class BaseDynamoService<E extends BaseDynamoEntity> implements IBaseService<E> {

    protected final BaseDynamoRepository<E> repository;

    public BaseDynamoService(BaseDynamoRepository<E> repository) {
        this.repository = repository;
    }

    @Override
    public void save(E entity) {
        repository.save(entity);
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<E> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public List<E> findAll() {
        return repository.findAll();
    }
}
