package io.arichter.hotel.checkin.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DataSaidaInvalidException extends RuntimeException {

    public DataSaidaInvalidException() {
        super("Data de saída deve ser maior que a data de entrada");
    }
}
