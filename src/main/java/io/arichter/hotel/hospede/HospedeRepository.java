package io.arichter.hotel.hospede;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.webmvc.RepositoryRestController;

@RepositoryRestResource(path = "hospedes")
public interface HospedeRepository extends JpaRepository<Hospede, Integer> {
}
