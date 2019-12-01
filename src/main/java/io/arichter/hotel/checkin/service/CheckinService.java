package io.arichter.hotel.checkin.service;

import io.arichter.hotel.checkin.Checkin;
import io.arichter.hotel.hospede.Hospede;

import java.util.List;

public interface CheckinService {

    List<Checkin> findCheckinByHospede(Hospede hospede);

    void beforeSave(Checkin checkin);

    Double getValorEstadia(Checkin checkin);

    Checkin getUltimaEstadia(Hospede hospede);

    Double getValorEstadias(Hospede hospede);
}
