CREATE TABLE servico (
    id          SERIAL,
    descricao   VARCHAR(50) NOT NULL
);

ALTER TABLE servico
    ADD CONSTRAINT servico_pk
        PRIMARY KEY (id);

COMMENT ON TABLE servico IS 'Serviço';
COMMENT ON COLUMN servico.id IS 'ID do serviço';
COMMENT ON COLUMN servico.descricao IS 'Descrição do serviço';
