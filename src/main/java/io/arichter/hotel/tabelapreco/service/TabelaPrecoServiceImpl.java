package io.arichter.hotel.tabelapreco.service;

import io.arichter.hotel.tabelapreco.TabelaPreco;
import io.arichter.hotel.tabelapreco.TabelaPrecoRepository;
import io.arichter.hotel.tabelapreco.exception.ValorNotValidException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TabelaPrecoServiceImpl implements TabelaPrecoService {

    private TabelaPrecoRepository tabelaPrecoRepository;

    public TabelaPrecoServiceImpl(TabelaPrecoRepository tabelaPrecoRepository) {
        this.tabelaPrecoRepository = tabelaPrecoRepository;
    }

    @Override
    public TabelaPreco upate(TabelaPreco tabelaPreco, Double novoValor) {
        if (novoValor < 0) {
            throw new ValorNotValidException();
        }

        tabelaPreco.setValor(novoValor);

        return tabelaPrecoRepository.save(tabelaPreco);
    }

    @Override
    public List<TabelaPreco> findTabelasPreco() {
        return tabelaPrecoRepository.findAll();
    }
}
