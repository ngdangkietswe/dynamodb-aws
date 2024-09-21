package dev.ngdangkietswe.dynamodbaws.domains.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author ngdangkietswe
 * @since 9/21/2024
 */

@Getter
@AllArgsConstructor
public enum ResponseStatus {

    SUCCESS(0),
    UNKNOWN(-1),
    NOT_FOUND(-2),
    BAD_REQUEST(-3),
    ALREADY_EXISTS(-4),
    UNAUTHORIZED(-5),
    FORBIDDEN(-6),
    INTERNAL_SERVER_ERROR(-7);

    private final int code;
}
