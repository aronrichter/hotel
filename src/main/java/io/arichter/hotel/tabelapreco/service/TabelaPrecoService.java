package io.arichter.hotel.tabelapreco.service;

import io.arichter.hotel.tabelapreco.TabelaPreco;

import java.util.List;

public interface TabelaPrecoService {

    TabelaPreco upate(TabelaPreco tabelaPreco, Double novoValor);

    List<TabelaPreco> findTabelasPreco();
}
