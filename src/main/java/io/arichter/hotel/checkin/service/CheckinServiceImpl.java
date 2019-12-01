package io.arichter.hotel.checkin.service;

import io.arichter.hotel.checkin.Checkin;
import io.arichter.hotel.checkin.CheckinRepository;
import io.arichter.hotel.checkin.exception.DataSaidaInvalidException;
import io.arichter.hotel.hospede.Hospede;
import io.arichter.hotel.tabelapreco.service.TabelaPrecoService;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CheckinServiceImpl implements CheckinService {

    private TabelaPrecoService tabelaPrecoService;

    private CheckinRepository checkinRepository;

    public CheckinServiceImpl(TabelaPrecoService tabelaPrecoService, CheckinRepository checkinRepository) {
        this.tabelaPrecoService = tabelaPrecoService;
        this.checkinRepository = checkinRepository;
    }

    @Override
    public List<Checkin> findCheckinByHospede(Hospede hospede) {
        return checkinRepository.findByHospede(hospede);
    }

    @Override
    public void beforeSave(Checkin checkin) {
        if (checkin.getDataSaida() != null && checkin.getDataSaida().isBefore(checkin.getDataEntrada())) {
            throw new DataSaidaInvalidException();
        }
    }

    @Override
    public Double getValorEstadia(Checkin checkin) {
        LocalDate dataEntrada = checkin.getDataEntrada().toLocalDate();
        LocalDate dataSaida = checkDataSaida(checkin.getDataSaida());

        List<LocalDate> estadias = dataEntrada.datesUntil(dataSaida).collect(Collectors.toList());

        List<DayOfWeek> diasSemana = estadias.stream()
                .map(LocalDate::getDayOfWeek)
                .collect(Collectors.toList());

        return diasSemana.stream()
                .map(d -> tabelaPrecoService.getValorDia(d.name(), checkin.getAdicionalVeiculo()))
                .mapToDouble(Double::doubleValue)
                .sum();

    }

    public LocalDate checkDataSaida(LocalDateTime localDateTime) {
        if ((localDateTime.getHour() > 16) || (localDateTime.getHour() == 16 && localDateTime.getMinute() > 30)) {
            return localDateTime.plusDays(1).toLocalDate();
        }

        return localDateTime.toLocalDate();
    }

    @Override
    public Checkin getUltimaEstadia(Hospede hospede) {
        LocalDateTime dataAtual = LocalDateTime.now();

        List<Checkin> checkins =
                checkinRepository.findByHospedeAndDataSaidaBeforeOrderByDataSaidaDesc(hospede, dataAtual);

        return checkins.stream().findFirst().orElse(null);
    }

    @Override
    public Double getValorEstadias(Hospede hospede) {
        List<Checkin> checkins = checkinRepository.findByHospede(hospede);

        return checkins.stream()
                .map(this::getValorEstadia)
                .mapToDouble(Double::doubleValue)
                .sum();
    }
}
