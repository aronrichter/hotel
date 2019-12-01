package io.arichter.hotel.servico;

public enum Servicos {

    HOSPEDAGEM(1),
    VALLET(2);

    private Integer id;

    Servicos(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
