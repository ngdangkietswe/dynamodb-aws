package dev.ngdangkietswe.dynamodbaws.exceptions;

/**
 * @author ngdangkietswe
 * @since 9/21/2024
 */

public class DataNotFoundException extends RuntimeException {

    public DataNotFoundException(String message) {
        super(message);
    }

    public DataNotFoundException(Object obj, String id) {
        this(String.format("Data not found for entity %s with id %s", obj.getClass().getSimpleName(), id));
    }
}
