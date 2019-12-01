package io.arichter.hotel.tabelapreco.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ValorNotValidException extends RuntimeException {

    public ValorNotValidException() {
        super("Valor não pode ser menor que zero");
    }
}
