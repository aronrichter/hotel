package io.arichter.hotel.servico;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Servico {

    @Id
    private Integer id;

    private String descricao;
}
