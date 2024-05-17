package server.sopt.server.exception;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum SuccessMessage {
    /**
     * 200 OK SUCCESS
     */
    PROCESS_SUCCESS(HttpStatus.OK.value(), "OK"),

    /**
     * 201 CREATED SUCCESS
     */
    ;

    private final int status;
    private final String message;
}
