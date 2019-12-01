package io.arichter.hotel.servico;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServicoRepository extends JpaRepository<Servico, Integer> {

    List<Servico> findByIdIn(List<Integer> ids);
}
