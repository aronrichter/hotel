package io.arichter.hotel.hospede.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NomeWrongLengthException extends RuntimeException {

    public NomeWrongLengthException() {
        super("Nome deve ter no máximo 50 caracteres");
    }
}
