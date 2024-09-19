package dev.ngdangkietswe.dynamodbaws.domains.product.entities;

import dev.ngdangkietswe.dynamodbaws.domains.common.BaseDynamoEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

/**
 * @author ngdangkietswe
 * @since 9/15/2024
 */

@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(setterPrefix = "set", builderMethodName = "newBuilder")
@DynamoDbBean
public class Product extends BaseDynamoEntity {

    private String name;
    private Double price;
    private Long stockCount;

    @DynamoDbAttribute("name")
    public String getName() {
        return name;
    }

    @DynamoDbAttribute("price")
    public Double getPrice() {
        return price;
    }

    @DynamoDbAttribute("stock_count")
    public Long getStockCount() {
        return stockCount;
    }
}
