package io.arichter.hotel.hospede.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ExistsCheckinException extends RuntimeException {

    public ExistsCheckinException() {
        super("Não é possível excluir um hospede que já possui histórico de check-in");
    }
}
