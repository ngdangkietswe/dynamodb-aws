package dev.ngdangkietswe.dynamodbaws.domains.common.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author ngdangkietswe
 * @since 9/16/2024
 */

@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(setterPrefix = "set", builderMethodName = "newBuilder")
@DynamoDbBean
public abstract class BaseDynamoEntity implements Serializable {

    private String id;
    private String createdAt;
    private String updatedAt;

    @DynamoDbPartitionKey
    @DynamoDbAttribute("id")
    public String getId() {
        return id;
    }

    @DynamoDbAttribute("created_at")
    public String getCreatedAt() {
        return createdAt;
    }

    @DynamoDbAttribute("updated_at")
    public String getUpdatedAt() {
        return updatedAt;
    }

    public void prePersist() {
        var now = new Timestamp(System.currentTimeMillis());
        this.createdAt = this.updatedAt = now.toString();
    }

    public void preUpdate() {
        this.updatedAt = new Timestamp(System.currentTimeMillis()).toString();
    }
}
