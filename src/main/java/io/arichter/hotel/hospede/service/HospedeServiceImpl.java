package io.arichter.hotel.hospede.service;

import io.arichter.hotel.checkin.Checkin;
import io.arichter.hotel.checkin.service.CheckinService;
import io.arichter.hotel.hospede.Hospede;
import io.arichter.hotel.hospede.exception.CpfWrongSizeException;
import io.arichter.hotel.hospede.exception.ExistsCheckinException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Pattern;

@Service
public class HospedeServiceImpl implements HospedeService {

    private static final String CPF_PATTERN = "\\d{11}";

    private CheckinService checkinService;

    public HospedeServiceImpl(CheckinService checkinService) {
        this.checkinService = checkinService;
    }

    @Override
    public void checkCreate(Hospede hospede) {
        Pattern pattern = Pattern.compile(CPF_PATTERN);

        if (hospede.getCpf() != null && !pattern.matcher(hospede.getCpf()).matches()) {
            throw new CpfWrongSizeException();
        }
    }

    @Override
    public void checkDelete(Hospede hospede) {
        List<Checkin> checkins = checkinService.findCheckinByHospede(hospede);

        if (checkins != null || !checkins.isEmpty()) {
            throw new ExistsCheckinException();
        }
    }
}
