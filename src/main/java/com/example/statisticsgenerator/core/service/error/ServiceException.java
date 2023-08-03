package com.example.statisticsgenerator.core.service.error;

import com.example.statisticsgenerator.core.service.common.StaticMessageSource;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Value;

import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

@EqualsAndHashCode(callSuper = true)
@Value
public class ServiceException extends RuntimeException {

    int errorCode;

    public ServiceException(Exception exception, Object... args) {
        super(StaticMessageSource.getMessage(exception.getLabel(), args));
        this.errorCode = exception.getCode();
    }

    @Getter
    public static enum Exception {
        USER_NOT_FOUND(1, "onetoone.exception.user.not.found"),
        TECHNOLOGY_NOT_FOUND(8, "onetoone.exception.technology.not.found");


        Exception(int code, String label) {
            this.code = code;
            this.label = label;
        }

        private final int code;
        private final String label;
    }

    public static Optional<Exception> fromString(Integer code){
        return Stream.of(Exception.values()).filter(c -> Objects.equals(code, c.name())).findFirst();
    }

    public static Optional<Exception> fromCode(Integer code) {
        return Stream.of(Exception.values()).filter(c -> c.code==(code)).findFirst();
    }
}
