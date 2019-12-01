package io.arichter.hotel.checkin;

import io.arichter.hotel.checkin.payload.CheckinResponse;
import io.arichter.hotel.checkin.service.CheckinService;
import org.springframework.stereotype.Component;

@Component
public class CheckinFactory {

    private CheckinService checkinService;

    public CheckinFactory(CheckinService checkinService) {
        this.checkinService = checkinService;
    }

    public CheckinResponse create(Checkin checkin) {
        CheckinResponse checkinResponse = new CheckinResponse();

        checkinResponse.setId(checkin.getId());
        checkinResponse.setHospede(checkin.getHospede());
        checkinResponse.setDataEntrada(checkin.getDataEntrada());
        checkinResponse.setDataSaida(checkin.getDataSaida());
        checkinResponse.setAdicionalVeiculo(checkin.getAdicionalVeiculo());
        checkinResponse.setValorEstadia(checkinService.getValorEstadia(checkin));

        return checkinResponse;
    }
}
