package dev.ngdangkietswe.dynamodbaws.domains.common.mappers;

import dev.ngdangkietswe.dynamodbaws.domains.common.dtos.BaseDto;
import dev.ngdangkietswe.dynamodbaws.domains.common.entities.BaseDynamoEntity;
import org.springframework.beans.BeanUtils;

import java.util.List;

/**
 * @author ngdangkietswe
 * @since 9/21/2024
 */

public class BaseDynamoMapper<E extends BaseDynamoEntity, D extends BaseDto> {

    private final Class<E> clazzEntity;
    private final Class<D> clazzDto;

    public BaseDynamoMapper(Class<E> clazzEntity, Class<D> clazzDto) {
        this.clazzEntity = clazzEntity;
        this.clazzDto = clazzDto;
    }

    public E convertToEntity(D dto, String... ignores) {
        E entity = null;

        try {
            entity = clazzEntity.getDeclaredConstructor().newInstance();
            BeanUtils.copyProperties(dto, entity, ignores);
        } catch (Exception e) {
            // Ignore
        }

        return entity;
    }

    public D convertToDto(E entity, String... ignores) {
        D dto = null;

        try {
            dto = clazzDto.getDeclaredConstructor().newInstance();
            BeanUtils.copyProperties(entity, dto, ignores);
        } catch (Exception e) {
            // Ignore
        }

        return dto;
    }

    public List<D> convertToDtoList(List<E> entities) {
        return entities.stream()
                .map(this::convertToDto)
                .toList();
    }
}
