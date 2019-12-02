package io.arichter.hotel.tabelapreco.service;

import io.arichter.hotel.servico.Servico;
import io.arichter.hotel.servico.Servicos;
import io.arichter.hotel.servico.service.ServicoService;
import io.arichter.hotel.tabelapreco.TabelaPreco;
import io.arichter.hotel.tabelapreco.TabelaPrecoRepository;
import io.arichter.hotel.tabelapreco.exception.ValorNotValidException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TabelaPrecoServiceImpl implements TabelaPrecoService {

    private TabelaPrecoRepository tabelaPrecoRepository;

    private ServicoService servicoService;

    public TabelaPrecoServiceImpl(TabelaPrecoRepository tabelaPrecoRepository, ServicoService servicoService) {
        this.tabelaPrecoRepository = tabelaPrecoRepository;
        this.servicoService = servicoService;
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

    @Override
    public Double getValorDia(String diaSemana, Boolean adicionaVeiculo) {
        List<Servico> servicos;

        if (adicionaVeiculo) {
            servicos = servicoService.finddByIdIn(List.of(Servicos.HOSPEDAGEM.getId(), Servicos.VALLET.getId()));
        } else {
            servicos = servicoService.finddByIdIn(List.of(Servicos.HOSPEDAGEM.getId()));
        }

        List<TabelaPreco> tabelasPreco = tabelaPrecoRepository.findByDiaSemanaAndServicoIn(diaSemana, servicos);

        return tabelasPreco.stream().mapToDouble(TabelaPreco::getValor).sum();
    }
}
