package io.arichter.hotel.hospede.service;

import io.arichter.hotel.hospede.Hospede;
import io.arichter.hotel.hospede.exception.CpfWrongSizeException;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class HospedeServiceImpl implements HospedeService {

    private static final String CPF_PATTERN = "\\d{11}";

    @Override
    public void checkCreate(Hospede hospede) {
        Pattern pattern = Pattern.compile(CPF_PATTERN);

        if (hospede.getCpf() != null && !pattern.matcher(hospede.getCpf()).matches()) {
            throw new CpfWrongSizeException();
        }
    }
}
