package io.arichter.hotel.servico.service;

import io.arichter.hotel.servico.Servico;

import java.util.List;

public interface ServicoService {

    List<Servico> finddByIdIn(List<Integer> servicoIds);
}
