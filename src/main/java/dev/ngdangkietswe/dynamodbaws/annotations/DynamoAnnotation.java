package dev.ngdangkietswe.dynamodbaws.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author ngdangkietswe
 * @since 9/21/2024
 */

@Retention(RetentionPolicy.RUNTIME)
public @interface DynamoAnnotation {

    String tableName();
}
