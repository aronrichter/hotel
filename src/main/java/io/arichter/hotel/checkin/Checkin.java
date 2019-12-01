package io.arichter.hotel.checkin;

import io.arichter.hotel.hospede.Hospede;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Checkin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Hospede hospede;

    private LocalDateTime dataEntrada;
    private LocalDateTime dataSaida;
    private Boolean adicionalVeiculo;
}
