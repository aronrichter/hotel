package io.arichter.hotel.tabelapreco;

import io.arichter.hotel.servico.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TabelaPrecoRepository extends JpaRepository<TabelaPreco, Integer> {

    List<TabelaPreco> findByDiaSemanaAndServicoIn(String diaSemana, List<Servico> servicos);
}
