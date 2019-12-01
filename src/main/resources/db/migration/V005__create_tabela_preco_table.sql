CREATE TABLE tabela_preco (
    id           SERIAL,
    servico_id   INTEGER NOT NULL,
    dia_semana   VARCHAR(50) NOT NULL,
    valor        NUMERIC(10,2) NOT NULL
);

ALTER TABLE tabela_preco
    ADD CONSTRAINT tabela_preco_pk
        PRIMARY KEY (id);

ALTER TABLE tabela_preco
    ADD CONSTRAINT tabela_preco_servico_id_fk
        FOREIGN KEY (servico_id) REFERENCES servico (id);

COMMENT ON TABLE tabela_preco IS 'Tabela de preço';
COMMENT ON COLUMN tabela_preco.id IS 'ID da tabela de preço';
COMMENT ON COLUMN tabela_preco.servico_id IS 'Serviço da tabela de preço';
COMMENT ON COLUMN tabela_preco.dia_semana IS 'Dia da semana do serviço na tabela de preço';
COMMENT ON COLUMN tabela_preco.valor IS 'Valor do serviço na tabela de preço';