package io.arichter.hotel.tabelapreco;

import io.arichter.hotel.servico.Servico;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
public class TabelaPreco {

    @Id
    private Integer id;

    @ManyToOne
    private Servico servico;

    private String diaSemana;
    private Double valor;
}
