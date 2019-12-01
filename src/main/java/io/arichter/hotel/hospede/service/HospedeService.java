package io.arichter.hotel.hospede.service;

import io.arichter.hotel.hospede.Hospede;

import java.util.List;

public interface HospedeService {

    void checkSave(Hospede hospede);

    void checkDelete(Hospede hospede);

    List<Hospede> findHospede(String nome, String cpf, Integer telefone);
}
