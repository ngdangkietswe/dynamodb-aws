package dev.ngdangkietswe.dynamodbaws.domains.product.converters;

import dev.ngdangkietswe.dynamodbaws.domains.product.dtos.responses.ProductDto;
import dev.ngdangkietswe.dynamodbaws.domains.product.entities.Product;
import org.springframework.beans.BeanUtils;

import java.util.UUID;

/**
 * @author ngdangkietswe
 * @since 9/16/2024
 */

public class ProductConverter {

    public static Product toEntity(ProductDto dto) {
        var entity = new Product();
        BeanUtils.copyProperties(dto, entity);
        entity.setId(UUID.randomUUID().toString());
        return entity;
    }

    public static ProductDto toDto(Product entity) {
        var dto = new ProductDto();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }
}
