package dev.ngdangkietswe.dynamodbaws.domains.product.services.impls;

import dev.ngdangkietswe.dynamodbaws.domains.common.BaseDynamoService;
import dev.ngdangkietswe.dynamodbaws.domains.product.entities.Product;
import dev.ngdangkietswe.dynamodbaws.domains.product.repositories.ProductRepository;
import org.springframework.stereotype.Service;

/**
 * @author ngdangkietswe
 * @since 9/16/2024
 */

@Service
public class ProductService extends BaseDynamoService<Product> {

    public ProductService(ProductRepository productRepository) {
        super(productRepository);
    }
}
