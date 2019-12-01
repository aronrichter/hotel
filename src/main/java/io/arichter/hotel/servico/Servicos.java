package io.arichter.hotel.servico;

public enum Servicos {

    HOSPEDAGEM(1),
    VALLET(2);

    private Integer servico;

    Servicos(Integer servico) {
        this.servico = servico;
    }

    public Integer getServico() {
        return servico;
    }
}
