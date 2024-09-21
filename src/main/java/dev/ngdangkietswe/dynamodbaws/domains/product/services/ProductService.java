package dev.ngdangkietswe.dynamodbaws.domains.product.services;

import dev.ngdangkietswe.dynamodbaws.domains.common.services.BaseDynamoService;
import dev.ngdangkietswe.dynamodbaws.domains.product.dtos.ProductDto;
import dev.ngdangkietswe.dynamodbaws.domains.product.entities.ProductEntity;
import dev.ngdangkietswe.dynamodbaws.domains.product.mappers.ProductMapper;
import dev.ngdangkietswe.dynamodbaws.domains.product.repositories.ProductRepository;
import org.springframework.stereotype.Service;

/**
 * @author ngdangkietswe
 * @since 9/16/2024
 */

@Service
public class ProductService extends BaseDynamoService<ProductEntity, ProductDto> {

    public ProductService(ProductRepository productRepository, ProductMapper productMapper) {
        super(productRepository, productMapper);
    }
}
