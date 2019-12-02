package io.arichter.hotel.hospede;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "hospedes")
public interface HospedeRepository extends JpaRepository<Hospede, Integer> {

    List<Hospede> findByNomeContainingIgnoreCase(String nome);

    List<Hospede> findByCpf(String cpf);

    List<Hospede> findByTelefone(Integer telefone);
}
