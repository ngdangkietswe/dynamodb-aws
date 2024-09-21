package dev.ngdangkietswe.dynamodbaws.domains.common.services;

import dev.ngdangkietswe.dynamodbaws.domains.common.dtos.BaseDto;
import dev.ngdangkietswe.dynamodbaws.domains.common.entities.BaseDynamoEntity;
import dev.ngdangkietswe.dynamodbaws.domains.common.mappers.BaseDynamoMapper;
import dev.ngdangkietswe.dynamodbaws.domains.common.repositories.BaseDynamoRepository;
import dev.ngdangkietswe.dynamodbaws.exceptions.DataNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.UUID;

/**
 * @author ngdangkietswe
 * @since 9/16/2024
 */

public abstract class BaseDynamoService<E extends BaseDynamoEntity, D extends BaseDto> implements IBaseService<D> {

    protected final BaseDynamoRepository<E> repository;
    protected final BaseDynamoMapper<E, D> mapper;

    public BaseDynamoService(BaseDynamoRepository<E> repository, BaseDynamoMapper<E, D> mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public String save(D dto) {
        E entity;
        if (!ObjectUtils.isEmpty(dto.getId())) {
            entity = repository.findById(dto.getId())
                    .map(e -> {
                        BeanUtils.copyProperties(dto, e, "createdAt");
                        e.preUpdate();
                        return e;
                    })
                    .orElseThrow(() -> new DataNotFoundException("Data not found for entity with id " + dto.getId()));
        } else {
            entity = mapper.convertToEntity(dto);
            entity.setId(UUID.randomUUID().toString());
            entity.prePersist();
        }

        repository.save(entity);
        return entity.getId();
    }

    @Override
    public void deleteById(String id) {
        repository.findById(id).ifPresentOrElse(
                entity -> repository.deleteById(id),
                () -> {
                    throw new DataNotFoundException("Data not found for entity with id " + id);
                }
        );
    }

    @Override
    public D findById(String id) {
        return repository.findById(id)
                .map(mapper::convertToDto)
                .orElseThrow(() -> new DataNotFoundException("Data not found for entity with id " + id));
    }

    @Override
    public List<D> findAll() {
        return repository.findAll().stream()
                .map(mapper::convertToDto)
                .toList();
    }
}
