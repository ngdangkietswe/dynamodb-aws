package dev.ngdangkietswe.dynamodbaws.domains.common.responses;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import dev.ngdangkietswe.dynamodbaws.domains.common.enums.ResponseStatus;
import dev.ngdangkietswe.dynamodbaws.exceptions.DataAlreadyExistsException;
import dev.ngdangkietswe.dynamodbaws.exceptions.DataNotFoundException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.sql.Timestamp;
import java.util.Map;

/**
 * @author ngdangkietswe
 * @since 9/21/2024
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(setterPrefix = "set", builderMethodName = "newBuilder")
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseResponse<D> {

    private D data;
    private String message;
    private int code;
    private String status;
    private Map<String, String> errorDetails;
    private Timestamp timestamp;

    public static <D> BaseResponse<D> asSuccess() {
        return BaseResponse.<D>newBuilder()
                .setCode(ResponseStatus.SUCCESS.getCode())
                .setStatus(ResponseStatus.SUCCESS.name())
                .setTimestamp(new Timestamp(System.currentTimeMillis()))
                .build();
    }

    public static <D> BaseResponse<D> asSuccess(D data) {
        return BaseResponse.<D>newBuilder()
                .setCode(ResponseStatus.SUCCESS.getCode())
                .setStatus(ResponseStatus.SUCCESS.name())
                .setData(data)
                .setTimestamp(new Timestamp(System.currentTimeMillis()))
                .build();
    }

    public static <D> BaseResponse<D> asError(Exception e) {
        if (e instanceof DataNotFoundException) {
            return asError(ResponseStatus.NOT_FOUND, e.getMessage(), null);
        } else if (e instanceof DataAlreadyExistsException) {
            return asError(ResponseStatus.ALREADY_EXISTS, e.getMessage(), null);
        }
        return asError(ResponseStatus.UNKNOWN, e.getMessage(), null);
    }

    public static <D> BaseResponse<D> asError(ResponseStatus status, String message, Map<String, String> errorDetails) {
        return BaseResponse.<D>newBuilder()
                .setCode(status.getCode())
                .setStatus(status.name())
                .setMessage(message)
                .setErrorDetails(errorDetails)
                .setTimestamp(new Timestamp(System.currentTimeMillis()))
                .build();
    }
}
