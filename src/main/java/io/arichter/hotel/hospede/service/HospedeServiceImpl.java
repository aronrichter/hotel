package io.arichter.hotel.hospede.service;

import io.arichter.hotel.checkin.Checkin;
import io.arichter.hotel.checkin.service.CheckinService;
import io.arichter.hotel.hospede.Hospede;
import io.arichter.hotel.hospede.HospedeRepository;
import io.arichter.hotel.hospede.exception.CpfWrongSizeException;
import io.arichter.hotel.hospede.exception.ExistsCheckinException;
import io.arichter.hotel.hospede.exception.NomeWrongLengthException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Pattern;

@Service
public class HospedeServiceImpl implements HospedeService {

    private static final String CPF_PATTERN = "\\d{11}";

    private CheckinService checkinService;

    private HospedeRepository hospedeRepository;

    public HospedeServiceImpl(CheckinService checkinService, HospedeRepository hospedeRepository) {
        this.checkinService = checkinService;
        this.hospedeRepository = hospedeRepository;
    }

    @Override
    public void checkSave(Hospede hospede) {
        Pattern pattern = Pattern.compile(CPF_PATTERN);

        if (hospede.getCpf() != null && !pattern.matcher(hospede.getCpf()).matches()) {
            throw new CpfWrongSizeException();
        }

        if (hospede.getNome() != null && hospede.getNome().length() > 50) {
            throw new NomeWrongLengthException();
        }
    }

    @Override
    public void checkDelete(Hospede hospede) {
        List<Checkin> checkins = checkinService.findCheckinByHospede(hospede);

        if (checkins == null || !checkins.isEmpty()) {
            throw new ExistsCheckinException();
        }
    }

    @Override
    public List<Hospede> findHospede(String nome, String cpf, Integer telefone) {
        if (nome != null && !nome.isEmpty()) {
            return hospedeRepository.findByNomeContainingIgnoreCase(nome);
        }

        if (cpf != null && !cpf.isEmpty()) {
            return hospedeRepository.findByCpf(cpf);
        }

        if (telefone != null) {
            hospedeRepository.findByTelefone(telefone);
        }

        return hospedeRepository.findAll();
    }
}
