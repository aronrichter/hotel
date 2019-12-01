package io.arichter.hotel.hospede;

import io.arichter.hotel.checkin.Checkin;
import io.arichter.hotel.checkin.CheckinFactory;
import io.arichter.hotel.checkin.service.CheckinService;
import io.arichter.hotel.hospede.payload.HospedeResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class HospedeFactory {

    private CheckinService checkinService;

    private CheckinFactory checkinFactory;

    public HospedeFactory(CheckinService checkinService, CheckinFactory checkinFactory) {
        this.checkinService = checkinService;
        this.checkinFactory = checkinFactory;
    }

    public HospedeResponse create(Hospede hospede) {
        HospedeResponse hospedeResponse = new HospedeResponse();

        Checkin checkin = checkinService.getUltimaEstadia(hospede);

        hospedeResponse.setId(hospede.getId());
        hospedeResponse.setNome(hospede.getNome());
        hospedeResponse.setCpf(hospede.getCpf());
        hospedeResponse.setUltimaEstadia(checkinFactory.create(checkin));
        hospedeResponse.setValorTotal(checkinService.getValorEstadias(hospede));

        return hospedeResponse;
    }

    public List<HospedeResponse> create(List<Hospede> hospedes) {
        return hospedes.stream()
                .map(this::create)
                .collect(Collectors.toList());
    }
}
