package io.arichter.hotel.hospede.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CpfWrongSizeException extends RuntimeException {

    public CpfWrongSizeException() {
        super("CPF fora do padrão.");
    }
}
