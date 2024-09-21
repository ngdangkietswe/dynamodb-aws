package dev.ngdangkietswe.dynamodbaws.exceptions;

/**
 * @author ngdangkietswe
 * @since 9/21/2024
 */

public class DataAlreadyExistsException extends RuntimeException {

    public DataAlreadyExistsException(String message) {
        super(message);
    }

    public DataAlreadyExistsException(Object obj, String id) {
        this(String.format("Data already exists for entity %s with id %s", obj.getClass().getSimpleName(), id));
    }
}
