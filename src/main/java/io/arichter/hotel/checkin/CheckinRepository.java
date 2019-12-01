package io.arichter.hotel.checkin;

import io.arichter.hotel.hospede.Hospede;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "checkins")
public interface CheckinRepository extends JpaRepository<Checkin, Integer> {

    List<Checkin> findByHospede(Hospede hospede);
}
