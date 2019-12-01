package io.arichter.hotel.servico.service;

import io.arichter.hotel.servico.Servico;
import io.arichter.hotel.servico.ServicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicoServiceImpl implements  ServicoService {

    private ServicoRepository servicoRepository;

    public ServicoServiceImpl(ServicoRepository servicoRepository) {
        this.servicoRepository = servicoRepository;
    }

    @Override
    public List<Servico> finddByIdIn(List<Integer> servicoIds) {
        return servicoRepository.findByIdIn(servicoIds);
    }
}
