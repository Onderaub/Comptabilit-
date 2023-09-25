package com.simplon.storedvd.exceptions;


import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;
@Getter
@ResponseStatus(code = HttpStatus.NOT_FOUND, reason ="Client Not Found")

public class ClientNotFoundException extends ResponseStatusException {
    public String getReason;

    public ClientNotFoundException(HttpStatus status){
        super(status);
    }
    public ClientNotFoundException(HttpStatus status, String reason){
        super(status,reason);
    }
    public ClientNotFoundException(HttpStatus status, String reason, Throwable cause){
        super(status, reason, cause);
    }
}
