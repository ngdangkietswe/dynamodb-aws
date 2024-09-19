package dev.ngdangkietswe.dynamodbaws.domains.product.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author ngdangkietswe
 * @since 9/15/2024
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDto implements Serializable {

    private String id;
    private String name;
    private Double price;
    private Long stockCount;
}
