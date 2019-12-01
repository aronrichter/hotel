CREATE TABLE hospede (
    id         SERIAL,
    nome       VARCHAR(50) NOT NULL,
    telefone   INTEGER NOT NULL,
    cpf        VARCHAR(11) NOT NULL
);

ALTER TABLE hospede
    ADD CONSTRAINT hospede_pk
        PRIMARY KEY (id);

COMMENT ON TABLE hospede IS 'Hospede';
COMMENT ON COLUMN hospede.id IS 'ID do hospede';
COMMENT ON COLUMN hospede.nome IS 'Nome do hospode';
COMMENT ON COLUMN hospede.telefone IS 'Telefone do hospode';
COMMENT ON COLUMN hospede.cpf IS 'CPF do hospede';