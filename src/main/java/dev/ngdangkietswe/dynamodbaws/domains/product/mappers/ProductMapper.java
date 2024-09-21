package dev.ngdangkietswe.dynamodbaws.domains.product.mappers;

import dev.ngdangkietswe.dynamodbaws.domains.common.mappers.BaseDynamoMapper;
import dev.ngdangkietswe.dynamodbaws.domains.product.dtos.ProductDto;
import dev.ngdangkietswe.dynamodbaws.domains.product.entities.ProductEntity;
import org.springframework.stereotype.Component;

/**
 * @author ngdangkietswe
 * @since 9/16/2024
 */

@Component
public class ProductMapper extends BaseDynamoMapper<ProductEntity, ProductDto> {

    public ProductMapper() {
        super(ProductEntity.class, ProductDto.class);
    }
}
