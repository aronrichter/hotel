package io.arichter.hotel.checkin.service;

import io.arichter.hotel.checkin.Checkin;
import io.arichter.hotel.checkin.CheckinRepository;
import io.arichter.hotel.hospede.Hospede;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckinServiceImpl implements CheckinService {

    private CheckinRepository checkinRepository;

    public CheckinServiceImpl(CheckinRepository checkinRepository) {
        this.checkinRepository = checkinRepository;
    }

    @Override
    public List<Checkin> findCheckinByHospede(Hospede hospede) {
        return checkinRepository.findByHospede(hospede);
    }
}
