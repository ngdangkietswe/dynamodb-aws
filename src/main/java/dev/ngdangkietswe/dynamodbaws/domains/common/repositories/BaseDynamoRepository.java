package dev.ngdangkietswe.dynamodbaws.domains.common.repositories;

import dev.ngdangkietswe.dynamodbaws.annotations.DynamoAnnotation;
import dev.ngdangkietswe.dynamodbaws.domains.common.entities.BaseDynamoEntity;
import org.springframework.data.repository.NoRepositoryBean;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;

import java.util.List;
import java.util.Optional;

/**
 * @author ngdangkietswe
 * @since 9/16/2024
 */

@NoRepositoryBean
public abstract class BaseDynamoRepository<E extends BaseDynamoEntity> implements IBaseRepository<E> {

    private final DynamoDbTable<E> dynamoDbTable;

    public BaseDynamoRepository(DynamoDbEnhancedClient dynamoDbEnhancedClient, Class<E> clazz) {
        this.dynamoDbTable = dynamoDbEnhancedClient.table(clazz.getAnnotation(DynamoAnnotation.class).tableName(), TableSchema.fromBean(clazz));
    }

    @Override
    public void save(E entity) {
        dynamoDbTable.putItem(entity);
    }

    @Override
    public List<E> findAll() {
        return dynamoDbTable.scan().items().stream().toList();
    }

    @Override
    public Optional<E> findById(String id) {
        return Optional.ofNullable(dynamoDbTable.getItem(r -> r.key(k -> k.partitionValue(id))));
    }

    @Override
    public void deleteById(String id) {
        dynamoDbTable.deleteItem(r -> r.key(k -> k.partitionValue(id)));
    }
}
