package dev.ngdangkietswe.dynamodbaws.domains.product.repositories;

import dev.ngdangkietswe.dynamodbaws.domains.common.repositories.BaseDynamoRepository;
import dev.ngdangkietswe.dynamodbaws.domains.product.entities.ProductEntity;
import org.springframework.stereotype.Repository;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;

/**
 * @author ngdangkietswe
 * @since 9/16/2024
 */

@Repository
public class ProductRepository extends BaseDynamoRepository<ProductEntity> {

    public ProductRepository(DynamoDbEnhancedClient dynamoDbEnhancedClient) {
        super(dynamoDbEnhancedClient, ProductEntity.class);
    }
}
